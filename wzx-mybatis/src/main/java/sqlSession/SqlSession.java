package sqlSession;

import executor.Executor;
import executor.Executorwzx;
import org.dom4j.DocumentException;

import java.lang.reflect.Proxy;
import java.sql.SQLException;

public class SqlSession {
    //执行器
    private Executor executor = new Executorwzx();
    //读取配置
    private Configuration configuration = new Configuration();

    //编写方法，返回一条记录
    public <T> T selectOne(String statement,Object parameter) throws SQLException, DocumentException, ClassNotFoundException {
        return executor.query(statement,parameter);
    }

    //返回mapper动态代理对象
    public <T> T getMapper(Class<T> clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},new MapperProxy(clazz,configuration,this));
    }
}
