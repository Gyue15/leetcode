package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num: nums) {
            int count;
            if (map.containsKey(num)) {
                count = map.get(num) + 1;
            } else {
                count = 1;
            }
            if (count > n / 2) {
                return num;
            }
            map.put(num, count);

        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int num: nums) {
            count = majority == num ? count + 1 : count - 1;
            if (count <= 0) {
                majority = num;
                count = 1;
            }
        }
        return majority;
    }


}
