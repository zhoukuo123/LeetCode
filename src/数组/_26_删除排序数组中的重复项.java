package 数组;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class _26_删除排序数组中的重复项 {
    // 双指针法
    // 时间复杂度 O(n)
    /*
    数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。

    当我们遇到 nums[j] != nums[i]时，跳过重复项的运行已经结束，因此我们必须把 nums[j] 的值复制到 nums[i + 1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    // 时间复杂度 O(n^2)
    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; ) {
            if (nums[i] == nums[i + 1]) {
                int index = i;
                for (int j = index + 1; j <= nums.length - 1; j++) {
                    nums[j - 1] = nums[j];
                }
                length--;
            } else {
                i++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        int len = new _26_删除排序数组中的重复项().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
