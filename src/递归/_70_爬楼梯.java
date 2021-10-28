package 递归;


/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class _70_爬楼梯 {
    // 时间复杂度: O(2^n) = O(n - 1) + O(n - 2)
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 优化
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
