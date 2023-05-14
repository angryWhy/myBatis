import Mapper.MonsterAnnotation;
import Mapper.MonsterMapper;
import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

public class TestCache {
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
    public void select(){
        Monster monster = monsterMapper.getMonsterById(7);
        if(sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("执行成功！"+monster);
    }
}
