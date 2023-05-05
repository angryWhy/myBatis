package Mapper;

import entity.Monster;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MonsterAnnotation {
    @Insert("INSERT INTO `monster` " +
            "(`age`,`birthday`,`email`,`name`,`salary`,`gender`) " +
            "VALUES (#{age},#{birthday},#{email},#{name},#{salary},#{gender})")
    //拿到自增长的id
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public void addMonster(Monster monster);

    @Delete("DELETE FROM `monster` WHERE id = #{id}")
    public void delMonster(Integer id);

    @Update("UPDATE `monster` " +
            "SET `age` = #{age},`name` = #{name},`birthday`=#{birthday},`salary`=#{salary},`gender`=#{gender},`email`=#{email} " +
            "WHERE id=#{id}")
    public void updateMonster(Monster monster);

    @Select("SELECT * FROM `monster` WHERE id=#{id}")
    public Monster getMonsterById(Integer id);

    @Select("SELECT * FROM `monster`")
    public List<Monster> findAllMonster();
}
