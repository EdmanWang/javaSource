package javaSource.concurrect.locks;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Condition 测试 demo
public class ConditionDemo {

    Integer capacity = 5;

    Stack<String> stack = new Stack<>();

    ReentrantLock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();

    public void pushStack(String item) {
        lock.lock();
        try {
            while (stack.size() == capacity) {
                stackFullCondition.await();
            }
            stack.push(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stackEmptyCondition.signalAll(); // 通知其他的线程可以执行
            lock.unlock();
        }
    }

    public String popStack() {
        lock.lock();
        try {
            while (stack.size() == 0) {
                stackEmptyCondition.await();
            }
            return stack.pop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stackFullCondition.signalAll();  // 通知其他的线程可以执行
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                conditionDemo.pushStack("wgx01");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String popStack = conditionDemo.popStack();
                System.out.println(popStack);
            }
        }).start();
    }
}
