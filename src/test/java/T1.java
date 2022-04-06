import com.bjpowernode.pojo.ProductType;
import com.bjpowernode.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wjs
 * @create 2022-04-04 17:58
 */
public class T1 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_service.xml");
        ProductService bean = context.getBean(ProductService.class);
        List<ProductType> all = bean.findAll();
        all.forEach(s->{
            System.out.println("s = " + s);
        });
    }
}
