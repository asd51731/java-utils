package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author asd51731
 * @Date 2019-06-17
 * @Ide IntelliJ IDEA
 */

public class DateUtils {

    /**
     * 将毫秒时间戳转为指定格式时间
     *
     * @param time
     * @param timeFormat
     * @return
     */
    public static String time2Str(Long time, String timeFormat) {
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        String d = format.format(new Date(time));
        return d;
    }

    /**
     * 获取指定格式当前时间字符串
     *
     * @param formatStr
     * @return
     */
    public static String getTimeStrNow(String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        String timeStr = format.format(new Date());
        return timeStr;
    }

    /**
     * 时间格式字符串转Date
     * @param timeStr
     * @param timeFormat
     * @return
     */
    public static Date str2Time(String timeStr, String timeFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        Date date = null;
        try {
            date = sdf.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取给定日期 dayAfter天后的日期
     *
     * @param timeStart
     * @param dayAter
     * @param timeFormat
     * @return
     */
    public static String getDaysAfter(Date timeStart, int dayAter, String timeFormat) {
        Date date = getTimeAfter(timeStart, dayAter, Calendar.DAY_OF_MONTH);
        return date2Str(date, timeFormat);
    }

    /**
     * 获取给定日期 minuteAter分钟后的日期
     *
     * @param timeStart
     * @param minuteAter
     * @param timeFormat
     * @return
     */
    public static String getMinutesAfter(Date timeStart, int minuteAter, String timeFormat) {
        Date date = getTimeAfter(timeStart, minuteAter, Calendar.MINUTE);
        return date2Str(date, timeFormat);
    }

    /**
     * 指定时间往后推移timeAfter单位时间（timeUnit，）得到的时间
     *
     * @param timeStart
     * @param timeAfter
     * @param timeUnit  如Calendar.MINUTE，Calendar.DAY_OF_MONTH等枚举
     * @return Date
     */
    public static Date getTimeAfter(Date timeStart, int timeAfter, int timeUnit) {
        Calendar c = Calendar.getInstance(); //日历
        c.setTime(timeStart);

        c.add(timeUnit, timeAfter);
        return c.getTime();
    }

    /**
     * Date转为指定格式字符串
     * @param date
     * @param timeFormat
     * @return
     */
    public static String date2Str(Date date, String timeFormat) {
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        String d = format.format(date);
        return d;
    }

    public static void main(String[] args) {
    }
}
