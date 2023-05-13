package Mapper;

import entity.MyBatisPet;

import java.util.List;

public interface MybatisPetMapper {
    //多个pet结果，用list
    List<MyBatisPet> getPetsById(Integer user_id);
    //通过pet的id获取pet
    MyBatisPet getPetById(Integer id);
}
