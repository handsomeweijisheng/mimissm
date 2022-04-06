//import com.bjpowernode.utils.MybatisUtils;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.junit.Test;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * @author wjs
// * @create 2022-03-10 15:37
// */
//public class TestLazy {
//    @Test
//    public void Lazy_Mybatis() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        AccoutDao mapper = sqlSession.getMapper(AccoutDao.class);
//        System.out.println(mapper.findByAid(1));
//    }
//}
