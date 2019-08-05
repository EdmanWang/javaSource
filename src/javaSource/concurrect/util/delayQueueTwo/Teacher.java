package javaSource.concurrect.util.delayQueueTwo;

import java.util.concurrent.DelayQueue;

public class Teacher implements Runnable {

    private DelayQueue<Student> delayQueue;

    public Teacher(DelayQueue<Student> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        System.out.println("------------ 考试开始 -----------");
        while (!Thread.interrupted()){ // 当老师线程没有打断的时候，就会一直监控学习这个延时队列
            try {
                delayQueue.take().run(); // 执行run方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
