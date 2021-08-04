package 动态规划;

/**
 * @author CoderZk
 * <p>
 * https://leetcode-cn.com/problems/coin-change/
 */
public class _322_零钱兑换 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));


    }

    public static int coinChange(int[] coins, int amount) {
        if (amount <= 0 || coins == null || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                if (dp[i - coin] < 0 || dp[i - coin] >= min) {
                    continue;
                }
                min = dp[i - coin];
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }

    static int coins4(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] dp = new int[n + 1];
        // faces[i]是凑够i分时最后选择的那枚硬币的面值
        int[] faces = new int[dp.length];
        for (int i = 1; i <= n; i++) {
//            dp[i] = min {dp[i - 25], dp[i - 20], dp[i - 5], dp[i - 1]} + 1;
            int min = Integer.MAX_VALUE;
            if (i >= 1 && dp[i - 1] < min) {
                min = dp[i - 1];
                faces[i] = 1;
            }
            if (i >= 5 && dp[i - 5] < min) {
                min = dp[i - 5];
                faces[i] = 5;
            }
            if (i >= 20 && dp[i - 20] < min) {
                min = dp[i - 20];
                faces[i] = 20;
            }
            if (i >= 25 && dp[i - 25] < min) {
                min = dp[i - 25];
                faces[i] = 25;
            }
            dp[i] = min + 1;
        }
        print(faces, n);
        return dp[n];
    }

    static void print(int[] faces, int n) {
        while (n > 0) {
            System.out.println(faces[n]);
            n -= faces[n];
        }
    }

    /**
     * 凑出n分钱所需要的最小硬币数
     * <p>
     * 递推(自底向上的调用)
     */
    static int coins3(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
//            dp[i] = min {dp[i - 25], dp[i - 20], dp[i - 5], dp[i - 1]} + 1;
            int min = Integer.MAX_VALUE;
            if (i >= 1) {
                min = Math.min(dp[i - 1], min);
            }
            if (i >= 5) {
                min = Math.min(dp[i - 5], min);
            }
            if (i >= 20) {
                min = Math.min(dp[i - 20], min);
            }
            if (i >= 25) {
                min = Math.min(dp[i - 25], min);
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }

    /**
     * 凑出n分钱所需要的最小硬币数
     * <p>
     * 记忆化搜索(自顶向下的调用)
     */
    static int coins2(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] dp = new int[n + 1];
        int[] faces = {1, 5, 20, 25};
        for (int face : faces) {
            if (n < face) {
                break;
            }
            dp[face] = 1;
        }

        return coins2(n, dp);
    }

    static int coins2(int n, int[] dp) {
        if (n <= 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[n] == 0) { // 如果上一次已经算过, 直接return, 不需要在重复计算, 因为已经把之前计算过的值存起来了
            int min1 = Math.min(coins2(n - 25, dp), coins2(n - 20, dp));
            int min2 = Math.min(coins2(n - 5, dp), coins2(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }

        return dp[n];
    }

    /**
     * 凑出n分钱所需要的最小硬币数
     * <p>
     * 暴力递归 (自顶向下的调用, 出现了重叠子问题, 子问题进行了重复的计算)
     */
    static int coins1(int n) {
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        if (n == 25 || n == 20 || n == 5 || n == 1) {
            return 1;
        }

        int min1 = Math.min(coins1(n - 25), coins1(n - 20));
        int min2 = Math.min(coins1(n - 5), coins1(n - 1));
        return Math.min(min1, min2) + 1;
    }


}
