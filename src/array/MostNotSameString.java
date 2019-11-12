package array;

/**
 * 奇安信笔试
 * @author ilovejava1314
 * @date 2019/11/12 20:04
 */
public class MostNotSameString {
    public static void main(String[] args) {
        System.out.println(max_length_substring("bcdbcdeebcdefghikl"));
    }

    static int max_length_substring(String s) {
        int max = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str = s.charAt(i)+"";
            for (int j = i + 1; j < s.length(); j++) {
                if (!str.contains(s.charAt(j)+"") && j!=s.length()-1) {
                    str = str+s.charAt(j);
                } else {
                    max = Math.max(str.length(),max);
                    str = "";
                    break;
                }
            }
        }
        return max;
    }
}
