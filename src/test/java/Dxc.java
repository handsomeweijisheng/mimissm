/**
 * @author wjs
 * @create 2022-04-02 22:54
 */
public class Dxc extends Thread {
    private static int sum=100;
    private static Object lock = new Object();
    public Dxc(String name) {
        super(name);
    }
    public Dxc() {

    }


    @Override
    public  void run() {
        while (true) {
        synchronized (lock) {

                if (sum > 0) {
                    System.out.println(Thread.currentThread().getName() +"还有"+sum+"张票");
                }
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sum--;
            }
        }
    }
}
