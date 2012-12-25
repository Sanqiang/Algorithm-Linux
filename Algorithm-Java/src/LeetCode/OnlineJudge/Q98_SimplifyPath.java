/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

import java.util.Stack;
import java.util.Iterator;

public class Q98_SimplifyPath {
    
    public String simplifyPath(String path) {
        String section[] = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < section.length; i++) {
            if (section[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (section[i].equals(".") || section[i].equals("")) {
            } else {
                stack.push(section[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        } else {
            for (Iterator<String> it = stack.iterator(); it.hasNext();) {
                String item = it.next();
                sb.append("/").append(item);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        String path2 = new Q98_SimplifyPath().simplifyPath(path);
        System.out.println(path2);
    }
}
