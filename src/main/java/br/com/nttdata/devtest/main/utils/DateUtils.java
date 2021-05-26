package br.com.nttdata.devtest.main.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String getStringCurrentDateTime() {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN);
            ZonedDateTime now = ZonedDateTime.now();
            return dtf.format(now);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Date getDateTimeFromString(String strDate) {
        return getDateFromString(strDate, DEFAULT_DATETIME_PATTERN);
    }

    public static Date getDateFromString(String strDate) {
        return getDateFromString(strDate, DEFAULT_DATE_PATTERN);
    }

    public static Date getDateFromString(String strDate, String pattern) {
        try {
            DateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            return sdf.parse(strDate);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static String getStringDateTime(Date date) {
        return getStringDate(date, DEFAULT_DATETIME_PATTERN);
    }

    public static String getStringDate(Date date) {
        return getStringDate(date, DEFAULT_DATE_PATTERN);
    }

    public static String getStringDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
