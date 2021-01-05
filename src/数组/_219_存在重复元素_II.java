package 数组;

import java.util.HashMap;

public class _219_存在重复元素_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else if (i - index <= k) {
                return true;
            } else {
                map.put(nums[i], i); // 用新index覆盖
            }
        }
        return false;
    }
}
