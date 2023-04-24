package mapper;

import Mapper.MonsterMapper;
import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.Date;

public class MonsterMapperTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;
//    执行测试目标方法之前，都要先执行这个方法
    @Before
    public void init(){
        //添加monster
        sqlSession= MyBatisUtils.getSqlSession();
        //获取到MonsterMapper对象
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);

    }

    @Test
    public void test(){
        System.out.println(1);
    }
    @Test
    public void add(){
        for (int i = 0; i < 2; i++) {
            Monster monster = new Monster();
            monster.setAge(i);
            monster.setBirthday("2023-02-02");
            monster.setEmail("875@qq.com");
            monster.setGender(3);
            monster.setSalary(10000.1);
            monster.setName("wwwww");
            System.out.println(monster);
            monsterMapper.addMonster(monster);
            System.out.println("自增长的id="+monster.getId());
        }
        if(sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("执行成功！");
    }
    @Test
    public void del(){
        monsterMapper.delMonster(21);
        if(sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("执行成功！");
    }
}
