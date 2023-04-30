package executor;

import entity.Monster;
import org.dom4j.DocumentException;
import sqlSession.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Executorwzx implements Executor{
    public Configuration configuration = new Configuration();
    @Override
    public <T> T query(String sql, Object parameter) throws SQLException, DocumentException, ClassNotFoundException {
        //得到Connection
        Connection connection = getConnection();
        //将来返回来的结果集
        ResultSet set = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement pre = connection.prepareStatement(sql);
        //设置参数
        pre.setString(1,parameter.toString());
        //执行,得到结果集
        set = pre.executeQuery();
        //把set数据封装到对象monster
        Monster monster = new Monster();
        while (set.next()){
            monster.setId(set.getInt("id"));
            monster.setName(set.getString("name"));
            monster.setEmail(set.getString("email"));
            monster.setAge(set.getInt("age"));
            monster.setGender(set.getInt("gender"));
            monster.setSalary(set.getDouble("salary"));
            monster.setBirthday(set.getDate("birthday"));
        }
        if(set!=null){
            set.close();
        }
        return null;
    }
    //得到连接
    public Connection getConnection() throws SQLException, DocumentException, ClassNotFoundException {
        Connection connection = configuration.build("wzx_mybatis.xml");
        return connection;
    }
}
