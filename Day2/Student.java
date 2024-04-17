package Day2;

public class Student {
	private Integer id;
	private String name;
	private Integer class_id;
	private Integer marks;
	private Character gender;
	private Integer age;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", class_id=" + class_id + ", marks=" + marks + ", gender="
				+ gender + ", age=" + age + ", status=" + status + "]";
	}

}
