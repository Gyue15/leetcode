package easy;

import util.PrintUtil;

public class Remove {
    public int removeElement(int[] nums, int val) {
        int offset = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                offset++;
            } else if (offset > 0) {
                nums[i - offset] = nums[i];
            }
        }

        return nums.length - offset;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int len = new Remove().removeElement(nums, 2);
        PrintUtil.printArr(nums, ""  +len);
    }
}
