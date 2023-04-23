package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//得到sqlsession
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    //编写静态代码块-初始化sqlSessionFactory
    static {
        //指定配置文件
        String resource = "mybatis-config.xml";
        //获取到文件流，默认到resources目录
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //编写方法，返回sqlSession对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
