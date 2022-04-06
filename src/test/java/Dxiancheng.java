/**
 * @author wjs
 * @create 2022-04-02 22:54
 */
public class Dxiancheng {
    public static void main(String[] args) {
        Dxc d = new Dxc();
        Thread t1 = new Thread(d,"窗口一");
        Thread t2 = new Thread(d,"窗口二");
        Thread t3 = new Thread(d,"窗口三");
        Thread t4 = new Thread(d,"窗口四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
