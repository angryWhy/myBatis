package test;

import Mapper.MonsterMapper;
import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    public void findMonsterByAge() {
        List<Monster> monsters = monsterMapper.findMonsterByAge(10);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void findAllMonster() {
        Monster monster1 = new Monster();
        monster1.setId(0);
        monster1.setName("wzx");
        List<Monster> monsters = monsterMapper.findAllMonster(monster1);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterByIdOrName() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", "wzx");
        List<Monster> monsters = monsterMapper.findMonsterByIdOrName(hashMap);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

//    传入集合，对应IN操作
    @Test
    public void findMonsterForeach() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ids", Arrays.asList(9, 12, 15));
        List<Monster> monsters = monsterMapper.findMonsterByIdForeach(map);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

//    Trim替换WHERE标签
    @Test
    public void findMonsterByName_Trim(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","wzx");
        map.put("age",10);
        List<Monster> monsters = monsterMapper.findMonsterByNameTrim(map);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void updateBySet(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","wzx");
        map.put("id",8);
        monsterMapper.updateMonsterBySet(map);
        //修改需要有commit
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
