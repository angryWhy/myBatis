package test;


import Mapper.MonsterMapper;
import Mapper.UserMapper;
import entity.Monster;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MonsterMapperTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    private UserMapper userMapper;

    //    执行测试目标方法之前，都要先执行这个方法
    @Before
    public void init() {
        //添加monster
        sqlSession = MyBatisUtils.getSqlSession();
        //获取到MonsterMapper对象，xml文件获取
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }

    //查找名字或者id
    @Test
    public void findMonsterByIdOrName() {
        Monster monster = new Monster();
        monster.setId(8);
        monster.setName("lao");
        List<Monster> monsters = monsterMapper.findMonsterByIdOrName(monster);
        for (Monster monster1 : monsters) {
            System.out.println(monster1);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    //模糊查找
    @Test
    public void findMonster() {
        List<Monster> monsters = monsterMapper.findMonster("w");
        for (Monster monster1 : monsters) {
            System.out.println(monster1);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    //map查询
    @Test
    public void findMapMonster() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 10);
        map.put("salary",40);
        List<Monster> monsters = monsterMapper.findMapMonster(map);
        for (Monster monster1 : monsters) {
            System.out.println(monster1);
        }
    }

    @Test
    public void returnMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 10);
        map.put("salary",40);
        List<Map<String,Object>> monsters = monsterMapper.returnMapMonster(map);
        for (Map<String,Object> monsterMap : monsters) {
            Set<String> strings = monsterMap.keySet();
            for(String key: strings){
                System.out.println(key+"===="+monsterMap.get(key));
            }
        }
    }
    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("哈哈哈");
        user.setPassword("123");
        userMapper.addUser(user);
        //增删改，需要提交事务
        if(sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
    @Test
    public void findAllUser(){
        List<User> users = userMapper.findAll();
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
