/**
 * @author wjs
 * @create 2022-04-02 22:45
 */
public class Demo {
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

