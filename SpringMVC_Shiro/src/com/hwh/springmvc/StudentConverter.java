package com.hwh.springmvc;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StudentConverter implements Converter<String, Student> {

	@Override
	public Student convert(String source) {
		if(source != null){
			System.out.println(source+" OK");
			String [] vals = source.split("-");
			//GG-gg@atguigu.com-0-105
			if(vals != null && vals.length == 2){
				String id= vals[0];
				String name = vals[1];
				int idi = Integer.parseInt(id);
				Student student=new Student();
				student.setId(idi);
				student.setName(name);
				System.out.println(source + "--convert--" + student);
				return student;
			}
		}
		return null;
	}

}
