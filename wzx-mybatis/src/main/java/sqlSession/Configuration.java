package sqlSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.sql.Connection;

//去取xml文件建立连接
public class Configuration {
    //属性：类的加载器
    private static ClassLoader loader = ClassLoader.getSystemClassLoader();
    //读取xml文件，并处理
    public Connection build(String resource) throws DocumentException {
        //加载wzx_mybatis.xml文件，获取到对应的InputStream
        InputStream stream = loader.getResourceAsStream(resource);
        //解析xml文件的，涉及到dom4j
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(stream);
        Element rootElement = document.getRootElement();
        return null;
    }
    public Connection evalDataSource(Element node){
        return null;
    }
}
