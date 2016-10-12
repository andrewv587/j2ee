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
			// ������ �����д����࣬����cp.getClass("com.slovef.JavassistClass");
			CtClass ctClass = cp.makeClass("com.slovef.JavassistClass");

			StringBuffer body = null;
			// ���� 1���������� 2���������� 3��������CtClass 4:Ĭ��ֵ
			CtField ctField = new CtField(cp.get("java.lang.String"), "name", ctClass);
			ctField.setModifiers(Modifier.PRIVATE);
			ctClass.addField(ctField, Initializer.constant("default"));

			// ֱ�����filed����
			CtField ct1 = CtField.make("private int id=10;", ctClass);
			ctClass.addField(ct1);

			// ����name���Ե�get set����
			ctClass.addMethod(CtNewMethod.setter("setName", ctField));
			ctClass.addMethod(CtNewMethod.getter("getName", ctField));

			// ���� 1���������� 2��������CtClass
			CtConstructor ctConstructor = new CtConstructor(new CtClass[] {}, ctClass);
			body = new StringBuffer();
			body.append("{\n name=\"me\";\n}");
			ctConstructor.setBody(body.toString());
			ctClass.addConstructor(ctConstructor);

			// ������ 1���������� 2���������� 3������������� 4��������CtClass
			CtMethod ctMethod = new CtMethod(CtClass.voidType, "execute", new CtClass[] {}, ctClass);
			ctMethod.setModifiers(Modifier.PUBLIC);
			body = new StringBuffer();
			body.append("{\n System.out.println(name);");
			body.append("\n System.out.println(\"execute ok\");");
			body.append("\n return ;");
			body.append("\n}");
			ctMethod.setBody(body.toString());
			ctClass.addMethod(ctMethod);

			// ���Ӵ��в����ķ���
			CtMethod ctMe = new CtMethod(CtClass.intType, "add", new CtClass[] { CtClass.intType, CtClass.intType },
					ctClass);
			ctMethod.setModifiers(Modifier.PUBLIC);
			ctMe.setBody("{System.out.println(\"add now\");return $1+$2;}");
			ctClass.addMethod(ctMe);

			// ֱ����ӷ���
			CtMethod meth1 = CtMethod.make("public void print(){System.out.println(\"hehe\");}", ctClass);
			ctClass.addMethod(meth1);

			// �ڸ�������ǰ��������
			ctMe.insertBefore("System.out.println($1);");
			ctMe.insertAfter("System.out.println($2);");

			// ��ȡ�ֽ����ļ����� ��ʱclass������,��defrosen���ɽⶳcc.defrost()
			byte[] by = ctClass.toBytecode();
			System.out.println(Arrays.toString(by));

			// ���ֽ����ļ�д��
			// ctClass.writeFile("e:/");
			// System.out.println(ctClass.getName()+"�ļ�д��");

			// ��ȡ����Ӧ������
			System.out.println(ctClass.getSimpleName());
			System.out.println(ctClass.getField("id"));

			// ������
			Class<?> c = ctClass.toClass();

			// ��ȡ���ʵ��
			Object o = c.newInstance();
			// ִ�з���
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
