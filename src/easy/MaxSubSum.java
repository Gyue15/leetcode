package easy;

public class MaxSubSum {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num: nums) {
            sum += num;
            if (sum > max) {
                max = sum;
            }
            if (sum  < 0) {
                sum = 0;
            }
        }
        return max;
    }


}
