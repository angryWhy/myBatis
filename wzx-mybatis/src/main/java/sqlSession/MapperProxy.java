package sqlSession;

import config.Function;
import config.MapperBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;
    public String mapperFile;
    private Configuration configuration;

    //初始化
    public MapperProxy(Class clazz, Configuration configuration,SqlSession sqlSession) {
        this.configuration = configuration;
        this.sqlSession = sqlSession;
        this.mapperFile = clazz.getSimpleName()+".xml";
    }

    //动态代理
    //执行mapper接口的代理对象方法时，会执行invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean mapperBean = configuration.readMapper(this.mapperFile);
        if(method.getDeclaringClass().getName().equals(mapperBean.getInterfaceName())){
            List<Function> functions = mapperBean.getFunctions();
            //解析mapper.xml之后，有方法
            if(null!=functions&&0!=functions.size()){
                for(Function function : functions){
                    if(method.getName().equals(function.getFuncName())){
                        //如果执行的方法是select，执行selectOne
                        if("select".equalsIgnoreCase(function.getSqlType())){
                            return sqlSession.selectOne(function.getSql(), String.valueOf(args[0]));
                        }
                    }
                }
            }
        }else{
            return null;
        }
        return null;
    }
}
