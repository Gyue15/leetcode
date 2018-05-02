package easy;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int exist = -1;
        int index = nums[0];
        int count = 0;
        while(count < nums.length) {
            count++;
            nums[index] = exist;
            index = nums[index];

        }
        return 0;
    }
}
