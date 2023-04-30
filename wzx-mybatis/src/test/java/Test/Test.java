package Test;

import org.dom4j.DocumentException;
import sqlSession.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    @org.junit.Test
    public void build(){
        Configuration configuration = new Configuration();
        try {
            Connection connection = configuration.build("wzx_mybatis.xml");
            System.out.println(connection);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
