package easy;

import util.PrintUtil;

public class Duplicate {
    public int removeDuplicatesSlow(int[] nums) {

        int len = 1;
        PrintUtil.printArr(nums, "i = 0");

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                boolean find = false;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j] && nums[j] > nums[i - 1]) {
                        find = true;
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                if (find) {
                    len++;
                } else {
                    return len;
                }
            } else {
                len++;
            }
            PrintUtil.printArr(nums, "i = " + i);
        }

        return len;
    }

    public int removeDuplicates(int[] nums) {
        int insertIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (i == nums.length - 1) {
                    nums[insertIndex] = nums[i];
                    insertIndex++;
                }
                continue;
            }
            nums[insertIndex] = nums[i - 1];
            insertIndex++;
            if (i == nums.length - 1) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
            PrintUtil.printArr(nums, "i = " + i);
        }
        return insertIndex > 0 ? insertIndex : 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        String len = "" + new Duplicate().removeDuplicates(nums);
        PrintUtil.printArr(nums, len);
    }
}
