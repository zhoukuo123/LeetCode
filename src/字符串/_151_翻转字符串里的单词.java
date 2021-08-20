package 字符串;

/**
 * @author CoderZk
 */
public class _151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        // 重要: 讲String转换为char数组
        char[] chars = s.toCharArray();

        // 1. 消除多余的空格
        int cur = 0; // 当前用来存放字符的位置
        // 前一个字符是否为空格字符
        boolean space = true;
        // 字符串最终的有效长度(需要翻转的长度)
        int len = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != ' ') {
                chars[cur++] = c;
                space = false;
            } else if (space == false) { // chars[i]是空格字符, chars[i-1]是非空格字符
                chars[cur++] = ' ';
                space = true;
            }
        }

        if (space) {
            len = cur - 1;
        } else {
            len = cur;
        }

        // 2. 逆序
        // 对整一个有效字符串进行逆序
        reverse(chars, 0, len);

        // 对每一个单词进行逆序
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                end = i;
                reverse(chars, start, end);
                start = i + 1;
            }
        }

        end = len;
        reverse(chars, start, end);

        return new String(chars, 0, len);
    }

    /**
     * 将[l, r) 范围内的字符串进行逆序 -> 逐个交换
     *
     * @param chars
     * @param l
     * @param r
     */
    private void reverse(char[] chars, int l, int r) {
        r--;

        while (l < r) {
            char tmp = chars[r];
            chars[r] = chars[l];
            chars[l] = tmp;
            l++;
            r--;
        }
    }
}
