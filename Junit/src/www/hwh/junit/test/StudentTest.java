package www.hwh.junit.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;
import org.junit.Test;


import www.hwh.test.Student;

public class StudentTest {
	
	private static Student stu=new Student();

	@Test
	public void testAdd() {
		int z = stu.add(3, 5);
		assertEquals("hehe",z, 8);
		
	}
	
	@Test
	public void testSubstract(){
		int z=stu.substract(4, 3);
		assertThat(z,is(1));
		assertEquals("hehe",z, 1);
	}
	
	@Test
	public void testDivde(){
		assertEquals(5,5);
	}
}
