package test;

import Mapper.PersonMapper;
import entity.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

public class PersonTest {
    private SqlSession sqlSession;
    private PersonMapper personMapper;

    @Before
    public void init() {
        //添加monster
        sqlSession = MyBatisUtils.getSqlSession();
        //获取到MonsterMapper对象，xml文件获取
        personMapper = sqlSession.getMapper(PersonMapper.class);
    }

    @Test
    public void getPerson() {
        Person person = personMapper.getPersonById(1);
        System.out.println(person);
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
