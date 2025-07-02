package step3.lec1easy;

import java.util.Arrays;

public class removeDupli {
    public static void main(String[] args) {
        int[] in = new int[] { 1, 2, 3, 4, 5, 7, 6, 7, 8, 8 };
        System.out.println(removeDuplicates(in));
        System.out.println(Arrays.toString(in));
    }

    public static int removeDuplicates(int[] nums) {
        int temp = 1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {

                nums[temp] = nums[i];
                max = nums[i];
                temp++;
            }
        }
        return temp;
    }
}
