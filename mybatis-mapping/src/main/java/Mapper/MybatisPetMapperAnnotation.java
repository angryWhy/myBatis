package Mapper;

import entity.MyBatisPet;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MybatisPetMapperAnnotation {
    @Select("SELECT * FROM `mybatis_pet` WHERE `user_id` = #{user_id}")
    @Results(id="petResultId",value={
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "users",column = "user_id",one = @One(select = "Mapper.MybatisUserMapperAnnotation.getUserById"))
    })
    List<MyBatisPet> getPetsById(Integer user_id);
    @Select("SELECT * FROM `mybatis_pet` WHERE `id` = #{id}")
    @ResultMap(value = "petResultId")
    MyBatisPet getPetById(Integer id);
}
