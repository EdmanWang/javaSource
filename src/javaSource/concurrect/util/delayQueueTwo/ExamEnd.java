package javaSource.concurrect.util.delayQueueTwo;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

// 考试结束
public class ExamEnd extends Student {

    private Thread teacherThread;

    private CountDownLatch countDownLatch;

    private DelayQueue<Student> delayQueue;

    public ExamEnd(Integer id, long workTime, Date putTime,Thread teacherThread, CountDownLatch countDownLatch, DelayQueue<Student> delayQueue) {
        super(id, workTime, putTime, countDownLatch);
        this.teacherThread = teacherThread;
        this.countDownLatch = countDownLatch;
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        System.out.println("考试结束");
        teacherThread.interrupt();
        delayQueue.stream().forEach((student) -> {
            student.setForce(true);
            student.run();
        });
        countDownLatch.countDown();
    }
}
