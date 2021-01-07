package 字符串;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class _剑指_Offer_05_替换空格 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
