package config;

import java.util.List;

//将mapper信息进行封装
public class MapperBean {
    //接口全路径
    private String interfaceName;
    //接口下的所有方法
    private List<Function> functions;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }
}
