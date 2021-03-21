import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName UserTest
 * @Description User模块测试类
 * @Author GengRui
 * @Date 2021/3/14 11:19
 */
@SuppressWarnings({"Duplicates"})
public class UserTest {
    public static void main(String[] args) throws IOException{
        // 读取配置文件
        InputStream configuration = Resources.getResourceAsStream("mybatis-config.xml");
        // 得到 SqlSessionFactory 核心类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // 开始一个 sql 会话
        SqlSession session = sqlSessionFactory.openSession();
        // 得到 mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
//        // 调用通过用户id查询用户信息的方法
//        User user = mapper.selectUserById(1);
//        System.out.println(user);
//        // 调用查询所有用户信息的方法
//        List<User> userList = mapper.selectUserList();
//        userList.forEach(u -> System.out.println(u))
        // 调用查询所有用户信息的方法
        List<User> userListBefore = mapper.selectUserList();
        userListBefore.forEach(u -> System.out.println(u));
        // 创建一个要新增的对象并赋值
        User insertUser = new User();
        insertUser.setId(6);
        insertUser.setUsername("anne");
        insertUser.setAge(18);
        insertUser.setScore(600);
        // 调用新增用户信息的方法
        int count = mapper.insertUser(insertUser);
        // 调用查询所有用户信息的方法
        List<User> userListAfter = mapper.selectUserList();
        userListAfter.forEach(u -> System.out.println(u));
        // 关闭会话
        session.close();
    }
}
