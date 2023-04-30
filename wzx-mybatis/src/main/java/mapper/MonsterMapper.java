package mapper;

import entity.Monster;

//声明对数据库的crud方法
public interface MonsterMapper {
    //获取方法
    Monster getMonster(Integer id);
}
