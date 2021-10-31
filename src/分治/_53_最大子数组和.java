package 分治;

/**
 * @author CoderZk
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class _53_最大子数组和 {

    // 分治: 时间复杂度O(), 空间复杂度O()
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return maxSubArray(nums, 0, nums.length);
    }

    /**
     * 求解[begin, end) 中最大连续子序列的和
     * T(n) = T(n/2) + T(n/2) + O(n)
     * T(n) = 2T(n/2) + O(n)
     * logba = 1 d = 1
     * T(n) = nlogn
     */
    public int maxSubArray(int[] nums, int begin, int end) {
        if (end - begin < 2) {
            return nums[begin];
        }
        int mid = (begin + end) >> 1;
        // 求出左边的最大连续子序列和
        int left = maxSubArray(nums, begin, mid);

        // 求出右边的最大连续子序列和
        int right = maxSubArray(nums, mid, end);

        int max1 = Math.max(left, right);

        // 求出 即包含左边 又 包含右边 的最大连续子序列和
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        int max = leftMax + rightMax;

        return Math.max(max, max1);
    }


    // 暴力: 时间复杂度O(n^3), 空间复杂度O(1)
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length; end++) {
                // sum是[begin, end]的和
                int sum = 0;
                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }


    // 暴力优化: 时间复杂度O(n^2), 空间复杂度O(1)
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                // sum是[begin, end]的和
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
