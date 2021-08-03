package 动态规划;

/**
 * @author CoderZk
 */
public class _最长公共子串 {
    public static void main(String[] args) {
        System.out.println(lcs("ABCD", "BABC"));
    }

    static int lcs(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if (chars1.length == 0) return 0;
        if (chars2.length == 0) return 0;

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int max = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    /**
     * 一维数组优化
     */
    static int lcs1(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if (chars1.length == 0) return 0;
        if (chars2.length == 0) return 0;
        char[] rowsChars = chars1, colsChars = chars2;
        if (chars1.length < chars2.length) {
            colsChars = chars1;
            rowsChars = chars2;
        }

        int[] dp = new int[colsChars.length + 1];
        int max = 0;
        for (int i = 1; i <= rowsChars.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsChars.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    max = Math.max(dp[j], max);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return max;
    }
}
