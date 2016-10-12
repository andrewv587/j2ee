package com.hwh.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hwh.model.Student;
import com.hwh.model.Topic;


public class MyBatisTest  {
	
	@Test
	public void basicTest()  throws IOException{
		String resource = "conf.xml"; 
		//加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource); 
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		
		//sessionFactory.openSession(true);表示自动提交
		

		//映射sql的标识字符串
		String statement = "com.hwh.dao.StudentMapper"+".getStudent";
		//执行查询返回一个唯一user对象的sql
		Student student = session.selectOne(statement, 24);
		System.out.println(student);
		
		session.clearCache();
		
		System.out.println(session.selectOne(statement, 24));
/*		String statement1 = "com.hwh.dao.StudentMapper"+".insertStudent";
		for(int i=1;i<10;i++){
			Student stu = new Student();
			stu.setId(i+4);
			stu.setAge(i);
			stu.setName("aaa");
			session.insert(statement1,stu);
		}
		*/
		
/*		String statement2 = "com.hwh.dao.StudentMapper"+".deleteStudent";
		session.delete(statement2,25);*/
		
		
/*		String statement2 = "com.hwh.dao.StudentMapper"+".updateStudent";
		Student stu = new Student();
		stu.setId(24);
		stu.setName("abc");
		
		session.update(statement2,stu);*/
		
		//映射sql的标识字符串
		String statement3 = "com.hwh.dao.StudentMapper"+".getStudents";
		//执行查询返回一个唯一user对象的sql
		List<Student> students = session.selectList(statement3, 1);
		System.out.println(students.size());
		
		
		String statement4= "com.hwh.dao.TopicMapper"+".getTopic";
		Topic topic=session.selectOne(statement4,4);
		System.out.println(topic.getId()+" "+topic.getTitle()+" "+
				topic.getCreateDate()+" "+topic.getCategory().getId());
		
		
		String statement5= "com.hwh.dao.TopicMapper"+".getTopic2";
		Topic topic1=session.selectOne(statement5,4);
		System.out.println(topic1.getId()+" "+topic1.getTitle()+" "+
				topic1.getCreateDate()+" "+topic1.getCategory().getId());
		//执行CUD时需要提交事务
		session.close();

	}
	
}
