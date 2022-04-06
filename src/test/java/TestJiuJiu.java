/**
 * @author wjs
 * @create 2022-02-25 12:32
 */
public class TestJiuJiu {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j+"*"+i+"="+i*j);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
