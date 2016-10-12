package com.hwh.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwh.dao.StudentMapper;
import com.hwh.model.Student;
import com.hwh.model.Topic;


@RunWith(SpringJUnit4ClassRunner.class) //ʹ��Springtest���Կ��
@ContextConfiguration("/beans.xml") //��������

public class MyBatisTest {

	@Autowired  //ע��
	private StudentMapper studentMapper;

	@Test
	public void save() {
		Student student = studentMapper.getStudent(29);
		System.out.println(student);
	}

}