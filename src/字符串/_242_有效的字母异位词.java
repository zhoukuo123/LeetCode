package 字符串;

/**
 * @author CoderZk
 */
public class _242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();


        if (schars.length != tchars.length) {
            return false;
        }

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            counts[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            counts[index]--;
            if (counts[index] < 0) {
                return false;
            }
        }
        return true;

        // a对应0 b对应1 直接拿字符-'a'就可以
        // 字符a的数量
//        counts[0] = 4;
        // 字符z的数量
//        counts[25] = 3;


    }
}
