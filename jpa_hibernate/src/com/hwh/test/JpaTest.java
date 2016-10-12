package com.hwh.test;

import static org.junit.Assert.*;

import javax.persistence.*;

import org.junit.*;

import com.hwh.model.Student;

public class JpaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void createTable(){
		//可以验证生成表是否正确
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		factory.close();
	}

	@Test
	public void save(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = new Student(); //Student为new状态
		student.setName("zhang san");
		student.setAge(10);
		em.persist(student); //持久化实体
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	//new 、托管、脱管、删除
	@Test 
	public void update(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		student.setName("hmk"); //Student为托管状态
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test
	public void update2(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		em.clear(); //把实体管理器中的所有实体变为脱管状态
		student.setName("hmk2");
		em.merge(student); //把脱管状态变为托管状态,merge可以自动选择insert or update 数据
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test public void remove(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		em.remove(student); //删除实体
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test public void find(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		Student student = em.find(Student.class, 2); //类似于hibernate的get方法,没找到数据时，返回null
		System.out.println(student.getName());
		em.close();
		factory.close();
	}
	@Test public void find2(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		Student student = em.getReference(Student.class, 2); //类似于hibernate的load方法,延迟加载.没相应数据时会出现异常
		System.out.println(student.getName()); //真正调用时才查找数据
		em.close();
		factory.close();
	}

}
