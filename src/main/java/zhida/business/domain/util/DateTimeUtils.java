package zhida.business.domain.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @文件名 DateTimeUtil
 * @描述 DateTimeUtil类
 * @Author xuzhiming
 * @创建日期 2020/5/6
 */
public class DateTimeUtils {

    /**
     * 获取当前日期
     *
     * @return 返回localdate
     */
    public static LocalDate getNowDate(){
        return LocalDate.now();
    }

    /**
     * 获取当前日期字符串
     *
     * @return  返回日期字符串 格式为yyyy-MM-dd
     */
    public static String getNowDateStr(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dtf.format(getNowDate());
    }

    /**
     * 日期转字符串
     *
     * @return  返回日期字符串 格式为yyyy-MM-dd
     */
    public static String dateConvertStr(LocalDate date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dtf.format(date);
    }

    /**
     * 按指定格式格式当前日期
     *
     * @param date 日期
     * @param formtter 日期格式
     * @return 返回日期字符串
     */
    public static String dateConvertStr(LocalDate date, String formtter){
        return getFormatter(formtter).format(date);
    }

    /**
     * 按指定格式格式当前日期
     *
     * @param formtter 日期格式
     * @return 返回日期字符串
     */
    public static String getNowDateStr(String formtter){
        return getFormatter(formtter).format(getNowDateTime());
    }

    /**
     * 时间字符串转localdate
     *
     * @param dateStr 日期字符串
     * @param formtter 日期格式
     * @return 返回日期字符串
     */
    public static LocalDate strConvertDate(String dateStr, String formtter){
        return LocalDate.parse(dateStr, getFormatter(formtter));
    }

    /**
     * 获取当前时间
     *
     * @return 返回LocalDateTime
     */
    public static LocalDateTime getNowDateTime(){
        return LocalDateTime.now();
    }

    /**
     * 获取当前时间字符串
     *
     * @return 返回时间字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDateTimeStr(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(getNowDateTime());
    }

    /**
     * 日期转字符串
     *
     * @return  返回时间字符串 格式为yyyy-MM-dd
     */
    public static String dateTimeConvertStr(LocalDateTime date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(date);
    }

    /**
     * 按指定格式格式当前时间
     *
     * @param date 时间
     * @param formtter 时间格式
     * @return 返回时间字符串
     */
    public static String dateTimeConvertStr(LocalDateTime date, String formtter){
        return getFormatter(formtter).format(date);
    }

    /**
     * 按指定格式格式当前时间
     *
     * @param formtter 时间格式
     * @return 返回时间字符串
     */
    public String getNowDateTimeStr(String formtter){
        return getFormatter(formtter).format(getNowDateTime());
    }

    /**
     * 获取今天星期
     *
     * @param
     * @return 今天星期
     */
    public static String getNowWeek(){
        String weekEn = String.valueOf(getNowDate().getDayOfWeek());
        return ConstantUtils.WEEK_CONTRAST.get(weekEn);
    }

    /**
     * 根据时间获取星期
     *
     * @param localDate 时间
     * @return 星期
     */
    public static String getWeekByDate(LocalDate localDate){
        String weekEn = String.valueOf(localDate.getDayOfWeek());
        return ConstantUtils.WEEK_CONTRAST.get(weekEn);
    }

    /**
     * 根据时间字符串获取星期
     *
     * @param localDateStr 时间字符串
     * @return 星期
     */
    public static String getWeekByDateStr(String localDateStr, String formtter){
        String weekEn = String.valueOf(strConvertDate(localDateStr, formtter).getDayOfWeek());
        return ConstantUtils.WEEK_CONTRAST.get(weekEn);
    }

    /**
     * 时间字符串转localdate
     *
     * @param dateStr 日期字符串
     * @param formtter 日期格式
     * @return 返回日期字符串
     */
    public static LocalDateTime strConvertDateTime(String dateStr, String formtter){
        return LocalDateTime.parse(dateStr, getFormatter(formtter));
    }

    /**
     * 获取时间格式刷
     *
     * @param formtter 时间格式
     * @return 时间格式刷
     */
    public static DateTimeFormatter getFormatter(String formtter){
        return DateTimeFormatter.ofPattern(formtter);
    }
}