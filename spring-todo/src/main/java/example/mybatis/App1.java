package example.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.jhta.todo.vo.User;

public class App1 {

	public static void main(String[] args) throws Exception {
		
		String resource = "example/mybatis/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		// db access 작업 수행하기
		//SqlSession session = sqlSessionFactory.openSession();
		//User user = (User) session.selectOne("getUserById", "hong");
		//session.close();
		//System.out.println(user);
		
		SqlSession session = sqlSessionFactory.openSession();
		// Magic!!
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.getUserById("hong");
		System.out.println(user);
		session.close();
	}
}
