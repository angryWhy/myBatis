package Mapper;

import entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    @Select("SELECT * FROM `person` WHERE `id` = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "card",column = "card_id",one = @One(select = "Mapper.IdenCardMapper.getIdenCardById"))
    })
    Person getPersonById(Integer id);
    Person getPersonById2(Integer id);

    Person getPersonById3(Integer card_id);
}
