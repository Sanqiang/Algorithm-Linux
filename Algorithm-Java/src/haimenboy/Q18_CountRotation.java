/**
 * Sanqiang Zhao Www.131X.Com Jan 25, 2013
 */
package haimenboy;

public class Q18_CountRotation {

    int find(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            if (nums[s] < nums[e]) {
                return e + 1;
            }
            int m = s + (e - s) / 2;
            if (nums[s] <= nums[m] && nums[m + 1] <= nums[e] && nums[s] >= nums[e]) {
                return m + 1;
            } else if (nums[s] <= nums[m]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7};
        int pos = new Q18_CountRotation().find(nums);
        System.out.println(pos);
        System.out.println(FindRotation(nums));
    }

    public static int FindRotation(int[] rotates) {
        //as we discussed in slides, the key is to use a binary-search similar way to fast-find rotation place
        int start = 0;
        int end = rotates.length - 1;//basically you can imagine we use a recursion-similar way but use loop to process

        //now the key for keep processing is before start index meets our end index
        while (start < end) {
            //as we say the other criterial to determine stopping the process is the sub-array is sorted!
            if (rotates[start] < rotates[end])//e.g. {1,2,3,4,5}
            {
                return end + 1;//notice end is the key position for output the rotation, and in our case, the length-5 array rotates by 5, thus it is equal to itself
            } else {
                //binary-search based key process
                int mid = (start + end) / 2;
                //ok now we check if the perfect cut-point is found
                //what is perfect cut-point? Think about {3,4,5,1,2} and we choose 5 then {3,4} and {1,2} are sorted!, thus we rotated by 3
                if (rotates[start] <= rotates[mid] && rotates[mid + 1] <= rotates[end]) {
                    return mid + 1;//here it is mid position we want to output, however, plus one is because index starts with 0
                } else if (rotates[start] <= rotates[mid])//if left half is sorted, thus the key is keep process in right half
                {
                    start = mid + 1;//similar as binary search to shrink the focus window
                } else//need keep track of left sub-array
                {
                    end = mid - 1;
                }
            }
        }
        //the system should already print out index in the loop, if coming here return an error
        return -1;
    }
}
