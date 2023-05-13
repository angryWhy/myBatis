package Mapper;

import entity.MyBatisUser;
import org.apache.ibatis.annotations.*;

public interface MybatisUserMapperAnnotation {
    @Select("SELECT * FROM `mybatis_user` WHERE `id` = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "pets",column = "id",many = @Many(select = "Mapper.MybasitPetMapperAnnotation.getPetsById"))
    })
    MyBatisUser getUserById(Integer id);
}
