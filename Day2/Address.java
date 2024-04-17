package Day2;

public class Address {
	private Integer id;
	private Long pin_code;
	private String city;
	private Integer student_id;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", pin_code=" + pin_code + ", city=" + city + ", student_id=" + student_id + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPin_code() {
		return pin_code;
	}

	public void setPin_code(long pin_code) {
		this.pin_code = pin_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

}
