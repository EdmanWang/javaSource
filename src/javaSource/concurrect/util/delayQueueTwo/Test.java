package javaSource.concurrect.util.delayQueueTwo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

public class Test {

    private static final Integer MIN_EXAM_TIME = 6000;  // 最小考试时间
    private static final Integer MAX_EXAM_TIME = 8000;  // 最长考试时间 30+ 90

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        DelayQueue<Student> delayQueue = new DelayQueue<>();

        int studentCount = 5;
        CountDownLatch countDownLatch = new CountDownLatch(studentCount);

        for (int i = 1; i <= studentCount; i++) {
            long workTime = new Long(String.valueOf(MIN_EXAM_TIME + random.nextInt(MAX_EXAM_TIME)));
            long delayTime = workTime;
            Instant instant = LocalDateTime.now(ZoneId.systemDefault()).plus(i, ChronoUnit.MINUTES).atZone(ZoneId.systemDefault()).toInstant();
            Date putTime = Date.from(instant);
            delayQueue.put(new Student(i, workTime, putTime, countDownLatch));
        }
        Thread teacherThread = new Thread(new Teacher(delayQueue));
        delayQueue.put(new ExamEnd(99999, 10000, new Date(), teacherThread, countDownLatch, delayQueue));
        teacherThread.start();
        countDownLatch.await();
    }
}
