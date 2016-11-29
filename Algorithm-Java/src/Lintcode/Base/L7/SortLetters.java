package Lintcode.Base.L7;

public class SortLetters {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        int left = 0 , right = chars.length - 1;
        while (left < right) {
			while (left < right && isLowerCase(chars[left])) {
				++left;
			}
			
			while (left < right && !isLowerCase(chars[right])) {
				--right;
			}
			
			if (left < right) {
				char temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
			}
		}
    }
    
    boolean isLowerCase(char ch){
    	return ch >= 'a' && ch <= 'z';
    }
}
