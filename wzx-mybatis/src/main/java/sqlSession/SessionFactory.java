package sqlSession;

//会话工厂，返回一个会话
public class SessionFactory {
    public static SqlSession openSession(){
        return new SqlSession();
    }
}
