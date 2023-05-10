package test;


import Mapper.IdenCardMapper;
import entity.IdenCard;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MapperTest {
    private SqlSession sqlSession;
    private IdenCardMapper idenCardMapper;

    @Before
    public void init() {
        //添加monster
        sqlSession = MyBatisUtils.getSqlSession();
        //获取到MonsterMapper对象，xml文件获取
        idenCardMapper = sqlSession.getMapper(IdenCardMapper.class);
    }
    //测试级联查询
    @Test
    public void getIdenCardById(){
        IdenCard idenCard= idenCardMapper.getIdenCardById(1);
        System.out.println(idenCard);
        if(sqlSession !=null){
            sqlSession.close();
        }
    }

}
