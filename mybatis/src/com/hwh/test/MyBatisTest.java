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
		//����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource); 
		//����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		
		//sessionFactory.openSession(true);��ʾ�Զ��ύ
		

		//ӳ��sql�ı�ʶ�ַ���
		String statement = "com.hwh.dao.StudentMapper"+".getStudent";
		//ִ�в�ѯ����һ��Ψһuser�����sql
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
		
		//ӳ��sql�ı�ʶ�ַ���
		String statement3 = "com.hwh.dao.StudentMapper"+".getStudents";
		//ִ�в�ѯ����һ��Ψһuser�����sql
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
		//ִ��CUDʱ��Ҫ�ύ����
		session.close();

	}
	
}
