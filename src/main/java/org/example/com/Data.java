package org.example.com;

import java.util.Calendar;
import java.util.Date;

public class Data {
    public static String getDataCurrent() {
        Date date = new Date();
        String str = date.toString();
        String[] subStr;
        String delimeter = " "; // Разделитель
        subStr = str.split(delimeter); // Разделения строки str с помощью метода split()
        String day = subStr[2];
        String month = subStr[1];
        String year = subStr[5];
        String month1 = month;
        if (month.equals("Jan")) month1 = "01";
        else if (month.equals("Feb")) month1 = "02";
        else if (month.equals("Mar")) month1 = "03";
        else if (month.equals("Apr")) month1 = "04";
        else if (month.equals("May")) month1 = "05";
        else if (month.equals("Jun")) month1 = "06";
        else if (month.equals("Jul")) month1 = "07";
        else if (month.equals("Aug")) month1 = "08";
        else if (month.equals("Sep")) month1 = "09";
        else if (month.equals("Oct")) month1 = "10";
        else if (month.equals("Nov")) month1 = "11";
        else month1 = "12";
        return year + "-" + month1 + "-" + day;
    }

    public static String getData(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, i);
        String str = calendar.getTime().toString();
        String[] subStr;
        String delimeter = " "; // Разделитель
        subStr = str.split(delimeter); // Разделения строки str с помощью метода split()
        String day = subStr[2];
        String month = subStr[1];
        String year = subStr[5];
        String month1 = month;
        if (month.equals("Jan")) month1 = "01";
        else if (month.equals("Feb")) month1 = "02";
        else if (month.equals("Mar")) month1 = "03";
        else if (month.equals("Apr")) month1 = "04";
        else if (month.equals("May")) month1 = "05";
        else if (month.equals("Jun")) month1 = "06";
        else if (month.equals("Jul")) month1 = "07";
        else if (month.equals("Aug")) month1 = "08";
        else if (month.equals("Sep")) month1 = "09";
        else if (month.equals("Oct")) month1 = "10";
        else if (month.equals("Nov")) month1 = "11";
        else month1 = "12";
        return year + "-" + month1 + "-" + day;
    }
}
