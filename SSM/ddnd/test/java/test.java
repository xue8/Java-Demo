//import cn.ddnd.www.Dao.UserDao;
//import cn.ddnd.www.Entity.User;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.io.Reader;
//import java.io.IOException;
//
//
//public class test {
//    private static Reader reader;
//    private static SqlSessionFactory sqlSessionFactory;
//    private static ApplicationContext applicationContext;
//
//    static{
////        只需要加载Spring的配置文件
//        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//    }
//    @Test
//    public void a() throws IOException {
////        try{
////            获取Mapper对象
//        UserDao userDao = (UserDao) applicationContext.getBean("userBean");
////            调用Mapper对象的方法
//        User user = userDao.getUser("xue8@qq.com");
//        System.out.println(user.getEmail());
//
//        //System.out.println("用户的邮箱是：" + user.getEmail() + "，用户的名称是：" + user.getName() + "，用户的密码是：" + user.getPassword());
////        }finally {
//////            sqlSession.close();
////        }
//    }
//}
