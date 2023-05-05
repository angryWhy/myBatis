package Mapper;

import entity.Monster;

import java.util.List;
import java.util.Map;


//这是一个接口
//该接口用于声明操作monster方法
//这些方法可以通过注解或者xml文件来实现
public interface MonsterMapper {
    //通过id或者名字查询
    public List<Monster> findMonsterByIdOrName(Monster monster);
    //查询名字包含‘精’的信息
    public List<Monster> findMonster(String name);
    //使用map查询
    public List<Monster> findMapMonster(Map<String, Object> map);
}