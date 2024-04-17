package Day2;
import java.util.*;
import java.util.stream.Collectors;
public class Passed {
	
	   public static List<Student> studentList=Operations.studentList;
	   public static List<Classes> classList=Operations.classList;
	   public static List<Address> addList=Operations.addList;
    public static List<Student> getPass(List<Student> studentList,Character gender,Integer age,Integer class_id,String city,Long pincode)
    { 
    	//System.out.println("4th task");
    	List<Student> rankedStudent = Ranking.ranking(studentList);
		List<Student> passedStudent = Filters.studFilterByStatusAgeClassGender(rankedStudent, age, class_id, gender);
		List<Integer> stud_id = Filters.getStudentIdByAddress(passedStudent, city,pincode);
		
		List<Student> student = passedStudent.stream().filter(s->stud_id.contains(s.getId())).collect(Collectors.toList());
		
//		student.forEach(System.out::println);
		if (student.isEmpty()) {
			return Collections.emptyList();
		} else {
			return student;
		}
    }
}
