package easy;

import util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public int[] twoSumQuick(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> backUp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                backUp.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        int[] res = new int[2];
        for (Integer key : map.keySet()) {
            if (map.containsKey(target - key) && key * 2 != target) {
                res[0] = map.get(key);
                res[1] = map.get(target - key);
                return res;
            } else if (map.containsKey(target - key) && key * 2 == target) {
                res[0] = map.get(key);
                res[1] = backUp.get(key);
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            } else {
                map.put(numbers[i], i);
            }
        }
        return null;
    }

    public static void main(String... args) {
        int[] arr = {2, 7, 11, 15};
        PrintUtil.printArr(new TwoSum().twoSum2(arr, 9), "twoSum");
    }

}

