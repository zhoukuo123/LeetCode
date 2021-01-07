package 字符串;

/**
 * https://leetcode-cn.com/problems/add-binary/
 */
public class _67_二进制求和 {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : ""); // 判断最后一次计算是否有进位
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        new _67_二进制求和().addBinary("101", "1011");
    }
}
