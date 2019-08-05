package javaSource.concurrect.util.delayQueueOne;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

// 消息体
public class Message implements Delayed {

    private Integer id;

    private String body;

    private long excuteTime;// 延迟时长，这个是必须的属性因为要按照这个判断延时时长。

    public Message(Integer id, String body, long delayTime) {
        this.id = id;
        this.body = body;
        this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(long excuteTime) {
        this.excuteTime = excuteTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);  // 默认是转换成毫秒值
    }

    @Override
    public int compareTo(Delayed delayed) { // 决定了在延时队列中添加的顺序
        Message message = (Message) delayed;
        return this.id > message.id ? 1 : ((this.id < message.id) ? -1 : 0);
    }
}
