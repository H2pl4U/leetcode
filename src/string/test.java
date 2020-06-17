package src.string;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {
    private static final String ReportID_DATE_FORMAT = "yyyyMMddHHmmss";

    private static final String ReportID_title = "MD-";

    public static String getReportID() {
        return ReportID_title + new SimpleDateFormat(ReportID_DATE_FORMAT).format(new Date());
    }

    public static boolean checkReportID(String reportID) {
        if (!reportID.substring(0,3).equals(ReportID_title) || reportID.length() != 18) {
            return false;
        }
        reportID = reportID.substring(3);
        SimpleDateFormat sdf = new SimpleDateFormat(ReportID_DATE_FORMAT);
        try {
            sdf.parse(reportID);
            return true;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Timestamp dateTimeParse(String timeStr) {
        return dateTimeParse(timeStr, "yyyy-MM-dd HH:mm:ss");
    }

    public static Timestamp dateTimeParse(String timeStr, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date date = sdf.parse(timeStr);
            return new Timestamp(date.getTime());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public static void main(String[] args) {
        
        List<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add("ddd");
        list1.add(0,list1.remove(3));
        list1.add(0,list1.remove(2));
        // list1.add(0,list1.remove(1));
        // list1.add(0,list1.remove(0));
        for (String str : list1) {
            System.out.println(str);
        }

    }
}