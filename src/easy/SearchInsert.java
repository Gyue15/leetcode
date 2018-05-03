package easy;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        boolean find = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target) {
                find = true;
            } else if (find) {
                return i;
            } else {
                return 0;
            }
        }
        return nums.length;
    }

}
