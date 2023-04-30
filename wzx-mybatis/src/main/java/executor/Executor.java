package executor;

import org.dom4j.DocumentException;

import java.sql.SQLException;

public interface Executor {
    <T>T query(String statement,Object parameter) throws SQLException, DocumentException, ClassNotFoundException;
}
