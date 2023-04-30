package sqlSession;

import config.Function;
import config.MapperBean;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

//去取xml文件建立连接
public class Configuration {
    Connection connection;
    //属性：类的加载器
    private static ClassLoader loader = ClassLoader.getSystemClassLoader();
    //读取xml文件，并处理
    public Connection build(String resource) throws DocumentException, SQLException, ClassNotFoundException {
        //加载wzx_mybatis.xml文件，获取到对应的InputStream
        InputStream stream = loader.getResourceAsStream(resource);
        //解析xml文件的，涉及到dom4j
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(stream);
        Element rootElement = document.getRootElement();
        connection = evalDataSource(rootElement);
        return connection;
    }
    public Connection evalDataSource(Element node) throws ClassNotFoundException, SQLException {
        if("database".equals(node.getName())){
            String driverClassName = null;
            String url = null;
            String username = null;
            String password = null;
            //遍历节点，获取属性
            for(Object item : node.elements("property")){
               Element i = (Element)item;
                String name = i.attributeValue("name");
                String value = i.attributeValue("value");
                if(name==null||value==null){

                }else{
                    switch (name){
                        case "url":
                            url = value;
                            break;
                        case "username":
                            username = value;
                            break;
                        case "password":
                            password = value;
                            break;
                        case "driverClassName":
                            driverClassName = value;
                            break;
                    }
                }
            }
            Class<?> aClass = Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
        return null;
    }


    //读取mapper文件
    public MapperBean readMapper(String path) throws DocumentException {
        MapperBean mapperBean = new MapperBean();
        InputStream resourceAsStream = loader.getResourceAsStream(path);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(resourceAsStream);
        Element root = document.getRootElement();
        String namespace = root.attributeValue("namespace");
        Iterator iterator = root.elementIterator();
        //保存遍历每个元素，保存方法信息
        ArrayList<Function> objects = new ArrayList<>();
        //遍历元素
        while (iterator.hasNext()){
            Element element = (Element)iterator.next();

        }
        return null;
    }
}
