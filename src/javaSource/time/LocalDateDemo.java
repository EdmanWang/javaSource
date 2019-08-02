package javaSource.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;


// LocalDate 测试 demo
public class LocalDateDemo {

    @Test
    public void testLocalDateOne() {
        LocalDate localDate = LocalDate.now(); // 用到了静态工厂模式

        // compareTo 直接是啊比较两个时间的大小，做减法
        int compareTo = localDate.compareTo(LocalDate.now().plus(10, ChronoUnit.DAYS));
        System.out.println("cpmpare to  " + compareTo);

        /**
         * 1: plusYears 指定在现在的时间日期上加上指定的年数
         * 2: plusMonths 指定在现在的时间日期上加上指定的月份数
         * 3：plusWeeks 在指定的时间日期上加上指定的周数
         * 4：plusDays 在指定的时间日期上加上指定的天数
         */
        LocalDate localDate1 = localDate.plusYears(1);
        LocalDate localDate2 = localDate.plusMonths(2);
        LocalDate localDate3 = localDate.plusWeeks(3);
        LocalDate localDate4 = localDate.plusDays(4);


        int i = localDate.get(ChronoField.DAY_OF_WEEK);
        System.out.println(i);

        int i1 = localDate.plusWeeks(3).get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        System.out.println(i1);

        int i2 = localDate.get(ChronoField.AMPM_OF_DAY); // java jdk 8 源码出现了问题
        System.out.println(i2);
    }

    @Test
    public void testLocalDateTwo() {
        /**
         * of 静态工厂方法，另外一种创建对象的方式
         */
        LocalDate localDate = LocalDate.of(1994, Month.DECEMBER, 23);

        /**
         * 将类型进行转换，即使转换成不同的格式或者说国家的语言输出
         */
        Temporal temporal = localDate.adjustInto(LocalDateTime.now());
        System.out.println(temporal);

        /**
         * 已 at 打头的函数就是将两个函数的结构组合起来
         */
        LocalDateTime localDateTime1 = localDate.atTime(10, 10);
        LocalDateTime localDateTime2 = localDate.atTime(LocalTime.now());
        LocalDateTime localDateTime = localDate.atStartOfDay();

        // 将日期对象格式化未string类型
        String format = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        /**
         * get：获取某些东西的值。
         */
        Month month = localDate.getMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfYear = localDate.getDayOfYear();


        /**
         * isAfter, isBefore, isEqual
         */
        boolean after = localDate.isAfter(LocalDate.now());
        boolean before = localDate.isBefore(LocalDate.now());
        boolean equal = localDate.isEqual(LocalDate.now());

        boolean supported = localDate.isSupported(ChronoUnit.MILLIS);
        boolean supported1 = localDate.isSupported(ChronoUnit.YEARS);
        boolean supported2 = localDate.isSupported(ChronoField.CLOCK_HOUR_OF_DAY);

        /**
         * minus:在目前日期的基础上进行减法
         */
        LocalDate minus = localDate.minus(1, ChronoUnit.YEARS);
        LocalDate localDate1 = localDate.minusWeeks(1);

        /**
         * with：返回一个部分状态改变了的时间日期对象拷贝(单独一个with方法,参数为TemporalAdjusters类型)
         */
        LocalDate localDate3 = localDate.withYear(2000);
        LocalDate localDate2 = localDate.withDayOfYear(1);
        LocalDate localDate4 = localDate.with(ChronoField.YEAR, 2010);
    }

    @Test
    public void testChangeTimeType(){
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate now = LocalDate.now();

        System.out.println(date);
        System.out.println(localDateTime);

        System.out.println("-------------------");

        /**
         * 将date 转换成 localDate
         * 将date 转换成 localDateTime,
         */
        LocalDateTime localDateTime1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime1);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);

        System.out.println("-------------------");

        /**
         * 将localDate 装换位date
         * 将localDateTime 装换位date
         */
        Instant instant1 = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date from = Date.from(instant1);
        System.out.println(from);
        Instant instant = now.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date from1 = Date.from(instant);
        System.out.println(from1);
    }
}
