package Mapper;

import entity.IdenCard;
import org.apache.ibatis.annotations.Select;

public interface IdenCardMapper {

    IdenCard getIdenCardById(Integer id);

    IdenCard getIdenCardById2(Integer id);
}
