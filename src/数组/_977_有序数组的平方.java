package 数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @author CoderZk
 * @date 2020/10/21 下午10:28
 */
public class _977_有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        /**
         * [-3, -3, -2, 1]
         * [1, -3, -2, -3]
         * [1, -3, -2 ,-3]
         * [1, -2, -3, -3]
         * 时间复杂度O(n^2)
         */
        int r = A.length - 1;

        for (int i = 0; i < A.length; i++) {
            while (i != r) {
                int v = A[i];
                if (v * v > A[r] * A[r]) {
                    swap(A, i, r--);
                } else {
                    r--;
                }
            }
            r = A.length - 1;
        }

        for (int j = 0; j < A.length; j++) {
            A[j] = A[j] * A[j];
        }
        return A;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int[] sortedSquares2(int[] A) {
        // 直接将数组A中的数平方后直接排序
        // 时间复杂度O(nlogn)
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares3(int[] A) {
        // 双指针
        // 时间复杂度O(n)
        int[] result = new int[A.length];
        int k = A.length - 1;
        int l = 0;
        int r = A.length - 1;
        while (l != r) {
            if (A[l] * A[l] > A[r] * A[r]) {
                result[k--] = A[l] * A[l];
                l++;
            } else {
                result[k--] = A[r] * A[r];
                r--;
            }
        }
        result[k] = A[l] * A[l];
        return result;
    }
}
