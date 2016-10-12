package www.hwh.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	public static void main(String[] args) {
		//生成dom4j，并读取XML
		File file = new File("Students.xml");
		SAXReader xmlReader = new SAXReader();
		try {
			Document doc = xmlReader.read(file);
			Element root = doc.getRootElement();
			Element student = root.element("student");
			Element name = student.element("name");
			Element age = student.element("age");
			
			//获取节点类型
			System.out.println(doc.getNodeTypeName());
			System.out.println(root.getNodeTypeName());
			System.out.println(root.element("student").attribute(0).getNodeTypeName());
			
			/*
			 * System.out.println(root.getName());
			 * System.out.println(student.getName()+" "+name.getName()+" "
			 * +name.getText()); System.out.println(student.getName()+" "
			 * +age.getName()+" "+age.getText());
			 */
			
			//获取节点下的子节点
			List stus = root.elements();
			for (int i = 0; i < stus.size(); i++) {
				Element student1 = (Element) stus.get(i);
				Element name1 = student1.element("name");
				Element age1 = student1.element("age");

				// System.out.println(root.getName());
				
				//可直接用student.elementText("name")
				
				System.out.println(student1.getName() + " " + name1.getName() + " " + name1.getText());
				System.out.println(student1.getName() + " " + age1.getName() + " " + age1.getText());

			}
			//获取节点的属性
			Iterator elementIterator = root.elementIterator();
			while (elementIterator.hasNext()) {
				Element element = (Element) elementIterator.next();
				//System.out.println(element.getName());
				Attribute att = element.attribute(0);
				//可直接用studnet.attribuetValue(0);
				System.out.println(att.getName()+" "+att.getValue());
				
			}
			//添加节点
			Element ele=root.addElement("student");
			ele.addAttribute("id", "06").addElement("name").addText("hehe");
			
			//输出XML
			//System.out.println(doc.asXML());
			
			//删除节点 root.removeElement(0)
			
			//利用xml
			Element ee=(Element) doc.selectSingleNode("//student[@id>2]");
			System.out.println(ee.attributeValue("id"));

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
