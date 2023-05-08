package Mapper;

import entity.Monster;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


//这是一个接口
//该接口用于声明操作monster方法
//这些方法可以通过注解或者xml文件来实现
public interface MonsterMapper {
    //年龄大于多少的情况下返回
    List<Monster> findMonsterByAge(@Param("age") Integer age);
    List<Monster> findAllMonster(Monster monster);
    List<Monster> findMonsterByIdOrName(Map<String,Object> map);
}