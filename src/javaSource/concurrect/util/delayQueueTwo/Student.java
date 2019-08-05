package javaSource.concurrect.util.delayQueueTwo;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

// 学生消息体
public class Student implements Delayed, Runnable {

    private Integer id; // 消息的id

    private long workTime; // 工作时长

    private Date putTime; // 上交时间

    private long delayTime; // 需要延时的时长

    private Boolean force = false;  // 是否强制上交作业

    private CountDownLatch countDownLatch; // 关闭锁线程

    public Student(Integer id, long workTime, Date putTime, CountDownLatch countDownLatch) {
        this.id = id;
        this.workTime = workTime;
        this.putTime = putTime;
        this.delayTime = TimeUnit.NANOSECONDS.convert(workTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        this.countDownLatch = countDownLatch;
    }

    public Boolean getForce() {
        return force;
    }

    public void setForce(Boolean force) {
        this.force = force;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.delayTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        if (delayed == null || !(delayed instanceof Student)) return 1;
        if (delayed == this) return 0;
        Student s = (Student) delayed;
        if (this.workTime > s.workTime) {
            return 1;
        } else if (this.workTime == s.workTime) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public void run() {
        if (force) {
            System.out.println("考试时间到，停止答题--------------");
        } else {
            System.out.println("id是" + id + "您的答题时长是" + workTime + "上交时间点事" + putTime + "答题结束");
        }
        countDownLatch.countDown();
    }
}
