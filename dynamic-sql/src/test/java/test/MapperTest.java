package test;

import Mapper.MonsterMapper;
import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.List;

public class MapperTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;
    @Before
    public void init() {
        //添加monster
        sqlSession = MyBatisUtils.getSqlSession();
        //获取到MonsterMapper对象，xml文件获取
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }
    @Test
    public void findMonsterByAge(){
        List<Monster> monsters = monsterMapper.findMonsterByAge(10);
        for(Monster monster : monsters){
            System.out.println(monster);
        }
        if(sqlSession != null){
            sqlSession.close();
        }
    }
    @Test
    public void findAllMonster(){
        Monster monster1 = new Monster();
        monster1.setId(0);
        monster1.setName("wzx");
        List<Monster> monsters = monsterMapper.findAllMonster(monster1);
        for(Monster monster : monsters){
            System.out.println(monster);
        }
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}
