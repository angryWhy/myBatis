package sqlSession;

import executor.Executor;
import executor.Executorwzx;
import org.dom4j.DocumentException;

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
}
