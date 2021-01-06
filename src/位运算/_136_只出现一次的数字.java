package 位运算;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class _136_只出现一次的数字 {
    // 异或运算 Time: O(n) Space: O(1)
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    // 哈希表 Time: O(n) Space: O(n)
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            count = count == null ? 1 : ++count;
            map.put(nums[i], count);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }
}
