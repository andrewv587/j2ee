package www.hwh.Annotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Test {

	public static void main(String[] args) {

		// 利用javcscript引擎
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		engine.put("abc", 123);
		String strr = "print(\"abc\")";
		try {
			engine.eval(strr);
		} catch (ScriptException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// 动态编译
		JavaCompiler jcp = ToolProvider.getSystemJavaCompiler();
		int result = jcp.run(null, null, null, "e:/HelloWorld.java");
		System.out.println(result == 0 ? "success!" : "wrong");
		// 执行java文件
		Runtime exce = Runtime.getRuntime();
		try {
			Process proe = exce.exec("java -cp e:/ HelloWorld");
			BufferedReader br = new BufferedReader(new InputStreamReader(proe.getInputStream()));
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// 可用反射执行main方法
		/*
		 * URL[] urls; try { urls = new URL[]{new URL("file:/"+"e:/")};
		 * ClassLoader cloder = new URLClassLoader(urls); Class c =
		 * cloder.loadClass("HelloWorld"); Method me1 = c.getMethod("main",
		 * String[].class); me1.invoke(null,null);
		 * 
		 * } catch (Exception e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */

		try {
			Class clazz = Class.forName("www.hwh.Annotation.Demo01");
			// 获取类名
			System.out.println(clazz.getName());
			System.out.println(clazz.getSimpleName());
			// 获取所有属性
			System.out.println(clazz.getDeclaredFields().length);
			System.out.println(clazz.getDeclaredField("id"));
			// 获取构造器
			Constructor cons = clazz.getConstructor(int.class, String.class, int.class);
			System.out.println(cons);
			// 反射构造 无参构造器（javabean模式）
			Demo01 demo = (Demo01) clazz.newInstance();
			System.out.println(demo.getAge());
			// 反射构造 调用有参构造器
			Demo01 demo1 = (Demo01) cons.newInstance(10, "abc", 21);
			System.out.println(demo1.getAge());

			// 调用类的方法
			Method method = clazz.getDeclaredMethod("setId", int.class);
			method.invoke(demo1, 44);
			System.out.println(demo1.getId());
			// 直接设置私有属性
			Field fi = clazz.getDeclaredField("id");
			fi.setAccessible(true);
			fi.set(demo1, 77);
			System.out.println(demo1.getId());

			// 获取类的注解
			Annotation[] anno = clazz.getAnnotations();
			for (Annotation tmp : anno) {
				System.out.println(tmp);
			}
			SxtTable tab = (SxtTable) clazz.getAnnotation(SxtTable.class);
			System.out.println(tab.value());

			// 获取属性的注解
			Field field = clazz.getDeclaredField("id");
			SxtField an = field.getAnnotation(SxtField.class);
			System.out.println(an.columnName() + "--" + an.type() + "--" + an.length());

		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | NoSuchMethodException
				| InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
