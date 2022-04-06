import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wjs
 * @create 2022-04-02 22:48
 */
public class Ticket extends Thread {
    // 声明变量 模拟车票 需要静态，保证车票被共享
    private static int num = 100;
    // 声明锁对象 需要静态，保证锁唯一
    private static Object lock = new Object();
    // 构造方法给线程命名
    public Ticket(String name) {
        super(name);
    }

    // 线程任务就是售票
    @Override
    public void run() {
        // 死循环模拟窗口在一直售票
        while ( true ) {
            // 同步代码块
            synchronized ( lock ) {
                // 判断是否还有车票
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票：" + num);
                    // 模拟出票时间
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 迭代车票
                    num--;
                }
            }
        }
    }
}
class A {
    public static void main(String[] args) {
        // 创建线程对象 模拟窗口
        Ticket ticket1 = new Ticket("窗口一");
        Ticket ticket2 = new Ticket("窗口二");
        Ticket ticket3 = new Ticket("窗口三");
        Ticket ticket4 = new Ticket("窗口四");
        // 启动线程
        ticket1.start();
        ticket2.start();
        ticket3.start();
        ticket4.start();
    }
}


