/*package com.hwh.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hwh.dao.StuMapper;
import com.hwh.model.Student;


public class MyBatisAnnotationTest  {
	
	@Test
	public void basicTest()  throws IOException{
		String resource = "conf.xml"; 
		//����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource); 
		//����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		//StuMapper mapper = session.getMapper(StuMapper.class);
		Student student = mapper.getStudent(26);
		System.out.println(student);
		
		List<Student> students=mapper.getStudents(1);
		System.out.println(students.size());
		
		Student stu = new Student();
		stu.setId(27);
		stu.setName("abcba");
		mapper.updateStudent(stu);
		
		
		mapper.insertStudent(10,"aaaa", 123);
		
		session.commit();
		session.close();

	}
	
}
*/