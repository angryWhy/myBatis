package mapper;

import Mapper.MonsterMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import util.MyBatisUtils;

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
}
