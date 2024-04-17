package Day2;
import java.util.*;
import java.util.stream.Collectors;
//import java.util.stream.Collectors;
public class Filters {
	public static List<Student> studentList = Operations.studentList;
	public static List<Classes> classList = Operations.classList;
	public static List<Address> addList = Operations.addList;
	
    public static List<Student> studFilterByStatusAgeClassGender(List<Student> studentList, Integer age,Integer class_id, Character gender) 
    {
    	List<Student> student=new ArrayList<>();
    	student=studentList.stream()
    			.filter(s -> s.getAge() <= 50 && s.getClass_id() == class_id && s.getGender() == gender)
    			.collect(Collectors.toList());
//    	student.forEach(System.out::println);
    	return student;
    }
    public static List<Integer> getStudentIdByAddress(List<Student> studentList, String city, Long pincode)
    {
    	List<Integer> student=new ArrayList<>();
    	student = addList.stream().filter(add -> add.getCity().equals(city) && add.getPin_code() == pincode)
				.map(e->e.getStudent_id()).collect(Collectors.toList());
    	
    	return student;
    }
    public static List<Student> studFailFilterByStatusAgeClassGender(List<Student> studentList, Integer age,
			Integer class_id, Character gender) {
		List<Student> student = new LinkedList<Student>();

		student = studentList.stream().filter(stud -> stud.getMarks() <= 50 && stud.getAge() < age
				&& stud.getClass_id() == class_id && stud.getGender() == gender).collect(Collectors.toList());
		return student;
	}
	public static List<Student> getStudentByGenderAgeCityPincode(List<Student> student, Character gender, Integer age,
			String city, Long pincode) {
		List<Integer> studentIdByCityPincode = getStudentIdByAddress(studentList, city, pincode);

		List<Student> students = new LinkedList<Student>();
		
		students = studentList.stream().filter(student1->student1.getGender().equals(gender) && student1.getAge() < age
					&& studentIdByCityPincode.contains(student1.getId())).collect(Collectors.toList());
		return students;
	}
}
