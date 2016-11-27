package Lintcode.Base.L1;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> results = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return results;
		}
		dfs(results, new ArrayList<String>(), 0, s, 0);
		return results;
	}

	void dfs(ArrayList<String> results, ArrayList<String> result, int pos, String s, int cnt_dot) {
		if (cnt_dot == 4 && pos == s.length()) {
			StringBuilder sBuilder = new StringBuilder();
			for (String ip : result) {
				sBuilder.append(ip).append(".");
			}
			sBuilder.deleteCharAt(sBuilder.length() - 1);
			results.add(sBuilder.toString());
			return;
		}else if (cnt_dot > 4) {
			return;
		}
		
		for (int i = pos; i < s.length(); i++) {
			String str = s.substring(pos, 1 + i);
			if (isValidIp(str)) {
				result.add(str);
				dfs(results, result, 1 + i, s, cnt_dot + 1);
				result.remove(result.size() - 1);
			}
		}
	}

	boolean isValidIp(String str) {
		if (str.length() > 3 || str.length() == 0) {
			return false;
		} else if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '9') {
			return true;
		} else if (str.length() == 2 && str.charAt(0) >= '1' && str.charAt(0) <= '9' && str.charAt(1) >= '0'
				&& str.charAt(1) <= '9') {
			return true;
		} else if (str.length() == 3) {
			if (str.charAt(0) == '1' && str.charAt(1) >= '0' && str.charAt(1) <= '9' && str.charAt(2) >= '0'
					&& str.charAt(2) <= '9') {
				return true;
			} else if (str.charAt(0) == '2' && str.charAt(1) >= '0' && str.charAt(1) <= '5' && str.charAt(2) >= '0'
					&& str.charAt(2) <= '5') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		List<String> results = new RestoreIpAddresses().restoreIpAddresses("101023");
		for (String result : results) {
			System.out.println(result);
		}
	}
}
