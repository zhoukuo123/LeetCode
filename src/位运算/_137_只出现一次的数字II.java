package 位运算;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 */
public class _137_只出现一次的数字II {
    // HashSet, 求和
    public int singleNumber1(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sum = 0;
        for (int num : nums) {
            set.add((long) num);
            sum += num;
        }
        long sum2 = 0;
        for (Long integer : set) {
            sum2 += integer;
        }
        return (int) ((sum2 * 3 - sum) / 2);
    }

    // HashMap, 直接判断次数为1
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    // 位运算, 不使用额外空间 Time: O(n) Space: O(1)
    public int singleNumber3(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) {
                    count++;
                }
            }
            // 找到某一位取余为 1 的数，并左移，为了将这一位循环结束后移至原位
            if (count % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new _137_只出现一次的数字II().singleNumber3(new int[]{2, 2, 3, 2});
    }
}
