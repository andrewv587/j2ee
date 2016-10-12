package www.hwh.Annotation;

import java.lang.reflect.Method;
import java.util.Arrays;

import javassist.*;
import javassist.CtField.Initializer;

public class Test02 {

	public static void main(String[] args) {
		/*
		 * System.out.println(ClassLoader.getSystemClassLoader());
		 * System.out.println(ClassLoader.getSystemClassLoader().getParent());
		 * System.out.println(ClassLoader.getSystemClassLoader().getParent().
		 * getParent());
		 * System.out.println(System.getProperty("java.class.path"));
		 */
		try {
			ClassPool cp = ClassPool.getDefault();
			// 创建类 若已有存在类，可用cp.getClass("com.slovef.JavassistClass");
			CtClass ctClass = cp.makeClass("com.slovef.JavassistClass");

			StringBuffer body = null;
			// 参数 1：属性类型 2：属性名称 3：所属类CtClass 4:默认值
			CtField ctField = new CtField(cp.get("java.lang.String"), "name", ctClass);
			ctField.setModifiers(Modifier.PRIVATE);
			ctClass.addField(ctField, Initializer.constant("default"));

			// 直接添加filed方法
			CtField ct1 = CtField.make("private int id=10;", ctClass);
			ctClass.addField(ct1);

			// 设置name属性的get set方法
			ctClass.addMethod(CtNewMethod.setter("setName", ctField));
			ctClass.addMethod(CtNewMethod.getter("getName", ctField));

			// 参数 1：参数类型 2：所属类CtClass
			CtConstructor ctConstructor = new CtConstructor(new CtClass[] {}, ctClass);
			body = new StringBuffer();
			body.append("{\n name=\"me\";\n}");
			ctConstructor.setBody(body.toString());
			ctClass.addConstructor(ctConstructor);

			// 参数： 1：返回类型 2：方法名称 3：传入参数类型 4：所属类CtClass
			CtMethod ctMethod = new CtMethod(CtClass.voidType, "execute", new CtClass[] {}, ctClass);
			ctMethod.setModifiers(Modifier.PUBLIC);
			body = new StringBuffer();
			body.append("{\n System.out.println(name);");
			body.append("\n System.out.println(\"execute ok\");");
			body.append("\n return ;");
			body.append("\n}");
			ctMethod.setBody(body.toString());
			ctClass.addMethod(ctMethod);

			// 增加带有参数的方法
			CtMethod ctMe = new CtMethod(CtClass.intType, "add", new CtClass[] { CtClass.intType, CtClass.intType },
					ctClass);
			ctMethod.setModifiers(Modifier.PUBLIC);
			ctMe.setBody("{System.out.println(\"add now\");return $1+$2;}");
			ctClass.addMethod(ctMe);

			// 直接添加方法
			CtMethod meth1 = CtMethod.make("public void print(){System.out.println(\"hehe\");}", ctClass);
			ctClass.addMethod(meth1);

			// 在给定方法前后插入代码
			ctMe.insertBefore("System.out.println($1);");
			ctMe.insertAfter("System.out.println($2);");

			// 读取字节码文件内容 此时class被冻结,用defrosen即可解冻cc.defrost()
			byte[] by = ctClass.toBytecode();
			System.out.println(Arrays.toString(by));

			// 将字节码文件写入
			// ctClass.writeFile("e:/");
			// System.out.println(ctClass.getName()+"文件写入");

			// 获取类相应的属性
			System.out.println(ctClass.getSimpleName());
			System.out.println(ctClass.getField("id"));

			// 加载类
			Class<?> c = ctClass.toClass();

			// 获取类的实例
			Object o = c.newInstance();
			// 执行方法
			Method method = o.getClass().getMethod("print", new Class[] {});

			method.invoke(o, new Object[] {});

			Method method12 = o.getClass().getMethod("add", new Class[] { int.class, int.class });
			int value = (int) method12.invoke(o, 100, 200);
			System.out.println(value);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
