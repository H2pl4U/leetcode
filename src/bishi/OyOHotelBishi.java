package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ABCD 2
 * ABCD -1
 *
 * CDAB
 * BCDA
 */
public class OyOHotelBishi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String s = "";
        //空字符串回车跳出输入
        while(!(s=in.nextLine()).equals("")) {
            list.add(s);
        }
        for (String str1: list) {
            String ss[] = str1.split(" ");
            String str = ss[0];
            int a = Integer.valueOf(ss[1]);
            if (a > 0) {
                str = str.substring(a) + str.substring(0,a);
            } else {
                str = str.substring(-a) + str.substring(0,-a);
            }
            System.out.println(str);
        }
    }
}
