package www.hwh.Annotation;

@SxtTable("Demo01")
public class Demo01 {
	@SxtField(columnName = "id", length = 10, type = "int")
	private int id;
	@SxtField(columnName = "id", length = 10, type = "varchar")
	private String name;
	@SxtField(columnName = "id", length = 10, type = "int")
	private int age;
	
	public Demo01(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Demo01(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
