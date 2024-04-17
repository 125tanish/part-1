package Day2;
import java.util.*;
import java.util.stream.Collectors;
public class Ranking {
   public static List<Student> studentList=Operations.studentList;
   public static List<Classes> classList=Operations.classList;
   public static List<Address> addList=Operations.addList;
   
   public static List<Student> ranking(List<Student> studentList)
   {
	   List<Student> student=studentList.stream().sorted((a, b) -> (b.getMarks()).compareTo(a.getMarks()))
				.collect(Collectors.toList());
	   
	   for(int i=0;i<student.size();i++)
	   {
		   if(i==0)
			   student.get(i).setStatus("First");
		   else if(i==1)
			   student.get(i).setStatus("Second");
		   else if(i==2)
			   student.get(i).setStatus("Third");
		   else if(student.get(i).getMarks()>50)
			   student.get(i).setStatus("Pass");
		   else
			   student.get(i).setStatus("Fail");
	   }
	   return student;
   }

public static List<Student> failStudentByAge(Integer age) {
	List<Student> students = studentList.stream().filter(s->s.getAge()>20).peek(s->s.setStatus("Fail")).collect(Collectors.toList());
	
	return students;
}
}
