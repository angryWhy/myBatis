package mapper;

import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.List;

public class MyBatisNativeTest {
    private SqlSession sqlSession;

    @Before
    public void init(){
        //获取到sqlsession
        sqlSession = MyBatisUtils.getSqlSession();
    }
    @Test
    //添加
    public void Crud(){
        Monster monster = new Monster();
        monster.setAge(25);
        monster.setBirthday("2023-05-02");
        monster.setEmail("875978822@qq.com");
        monster.setGender(16);
        monster.setSalary(20000.1);
        monster.setName("hello kitty");
        //要执行的接口的哪个方法
        //添加
        int insert = sqlSession.insert("Mapper.MonsterMapper.addMonster", monster);
        //删除
        int delete = sqlSession.delete("Mapper.MonsterMapper.delMonster", 10);
        //修改
        Monster monster2 = new Monster();
        monster2.setAge(25);
        monster2.setBirthday("2023-05-02");
        monster2.setEmail("875978822@qq.com");
        monster2.setGender(16);
        monster2.setSalary(20000.1);
        monster2.setName("hello 2222");
        monster2.setId(19);//必须有
        int update = sqlSession.update("Mapper.MonsterMapper.updateMonster", monster2);
        //查询所有
        List<Monster> monsters = sqlSession.selectList("Mapper.MonsterMapper.findAllMonster");
        //增伤改，需要提交事务
        if(sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println(insert+"-"+delete+"-"+update);
        System.out.println("执行成功！");
    }

}
