package easy;

public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int a = nums[0];                    //dp[i - 2]
        int b = Math.max(nums[0], nums[1]); //dp[i - 1]
        for (int i = 2; i < nums.length; i++) {
            int dp = Math.max(nums[i] + a, b);
            a = b;
            b = dp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{2,7,9,3,1}));
    }
}
