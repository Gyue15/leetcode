package easy;

public class Stock {

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(prices[i], buy);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }

    public int maxProfitII(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int gap = prices[i] - prices[i - 1];
            if (gap > 0) {
                profit += gap;
            }
        }
        return profit;
    }

    public int maxProfitOld(int[] prices) {
        return maxProfit(prices, 0, prices.length - 1);
    }

    private int maxProfit(int[] prices, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int leftProfit = maxProfit(prices, left, mid);
        int rightProfit = maxProfit(prices, mid + 1, right);
        int midProfit = getMax(prices, mid + 1, right) - getMin(prices, left, mid);
        return Math.max(Math.max(leftProfit, rightProfit), midProfit);
    }

    private int getMin(int[] nums, int left, int right) {
        int min = nums[left];
        for (int i = left; i <= right; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }

    private int getMax(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Stock().maxProfit(prices));
    }
}
