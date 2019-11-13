package bishi;

import java.nio.channels.NonWritableChannelException;
import java.util.Scanner;

/**
 * @author ilovejava1314
 * @date 2019/11/13 15:08
 */
public class Clock {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String nowTime = sc.nextLine();
//        String spendTime = sc.nextLine();
        String time = func("10:00:00","00:11:12");
        System.out.println(time);


    }

    private static String func(String nowTime, String spendTime) {
        String[] splitNowTime = nowTime.split(":");
        String[] splitSpendTime = spendTime.split(":");
        System.out.println(splitNowTime[0]);
        String[] time = new String[3];
        boolean flag = false;
         for (int i = 2; i >= 0; i--) {
             int sum = Integer.valueOf(splitNowTime[i] + splitSpendTime[i]);
             if (flag) {
                 sum++;
             }
             if (sum >= 60 && i > 0) {
                 flag=true;
                 time[i] = ":" + (sum - 60) + "";
             } else if (sum < 60 && i > 0) {
                 time[i] = ":" + sum + "";
             } else if (sum >= 24 && i == 0) {
                 time[i] = sum - 24 + "";
             } else if (sum < 24 && i == 0) {
                 time[i] = sum + "";
             }
             sum = 0;
        }
         return time[0]+time[1]+time[2];

    }


}
