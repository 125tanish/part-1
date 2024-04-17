package Day2;

public class Classes {
	private Integer id;
	private Character name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getName() {
		return name;
	}

	public void setName(Character name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + "]";
	}
}
