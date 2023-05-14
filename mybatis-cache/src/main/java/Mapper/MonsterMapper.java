package Mapper;

import entity.Monster;

import java.util.List;


//这是一个接口
//该接口用于声明操作monster方法
//这些方法可以通过注解或者xml文件来实现
public interface MonsterMapper {
    public void addMonster(Monster monster);
    public void delMonster(Integer id);
    public void updateMonster(Monster monster);
    public Monster getMonsterById(Integer id);
    public List<Monster> findAllMonster();
}