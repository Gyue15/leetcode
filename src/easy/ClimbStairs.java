package easy;

public class ClimbStairs {

    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length - 1;
        int a = cost[n - 1];
        int b = cost[n];
        for (int i = n - 2; i >= 0; i--) {
            int min = cost[i] + Math.min(a, b);
            b = a;
            a = min;
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int[] cost = {0,0,1,2};
        System.out.println(new ClimbStairs().minCostClimbingStairs(cost));
    }
}
