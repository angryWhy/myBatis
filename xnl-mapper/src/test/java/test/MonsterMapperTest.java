package test;


import Mapper.MonsterMapper;
import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.List;

public class MonsterMapperTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;


//    执行测试目标方法之前，都要先执行这个方法
    @Before
    public void init(){
        //添加monster
        sqlSession= MyBatisUtils.getSqlSession();
        //获取到MonsterMapper对象，xml文件获取
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }

    @Test
    public void findMonsterByIdOrName () {
        Monster monster = new Monster();
        monster.setId(8);
        monster.setName("lao");
        List<Monster> monsters = monsterMapper.findMonsterByIdOrName(monster);
        for( Monster monster1 : monsters){
            System.out.println(monster1);
        }
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}
