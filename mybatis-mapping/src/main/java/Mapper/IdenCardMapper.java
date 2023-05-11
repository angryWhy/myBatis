package Mapper;

import entity.IdenCard;
import org.apache.ibatis.annotations.Select;

public interface IdenCardMapper {
    @Select("SELECT * FROM `idencard` WHERE `id` = #{id}")
    IdenCard getIdenCardById(Integer id);
}
