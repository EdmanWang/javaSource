package javaSource.time;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import java.util.Date;

// Duration 测试 demo
public class DurationDemo {

    @Test
    public void testDuration() {
        /**
         * date 是有年月日时分秒的时间类型 按道理是对应localDateTime
         * Duration 最重要的函数是 between
         */
        Date start = new Date();
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.systemDefault()).plus(1, ChronoUnit.DAYS);
        LocalDateTime localDateTime1 = LocalDate.now(ZoneId.systemDefault()).plus(1, ChronoUnit.MONTHS).atTime(LocalTime.now(ZoneId.systemDefault()));

        LocalDateTime toLocalDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        long days = Duration.between(localDateTime1, toLocalDate).abs().getSeconds() / 24 / 60 / 60;
        System.out.println(days);

        Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(from);
    }
}
