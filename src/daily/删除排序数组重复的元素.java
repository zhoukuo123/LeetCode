package daily;

import java.util.Arrays;

public class 删除排序数组重复的元素 {
    // 双指针, 跳过重复项, 遇到不同的直接覆盖, 时间复杂度O(n), 空间复杂度O(1)原地修改数组
    public int deleteDuplicate(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    // 新建了一个数组, 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public int[] deleteDuplicate1(int[] nums) {
        int[] newArray = new int[nums.length];
        int j = 0;
        newArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (newArray[j] != nums[i]) {
                newArray[++j] = nums[i];
            }
        }
        nums = newArray;
        return nums;
    }

    // 最蠢的解法, O(n^2)
    public Integer[] deleteDuplicate2(Integer[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == null) return nums;

            if (nums[i].equals(nums[i + 1])) {
                int index = i + 1;
                for (int j = index + 1; j <= nums.length - 1; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[nums.length - 1] = null;
            } else {
                i++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 5, 5, 5, 9, 11, 11, 18, 18, 18, 18};
        int[] newnums = new 删除排序数组重复的元素().deleteDuplicate1(nums);
        System.out.println(Arrays.toString(newnums));
    }
}
