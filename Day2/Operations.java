package Day2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Operations {

	
	public static List<Student> studentList = new LinkedList<Student>();
	public static List<Classes> classList = new LinkedList<Classes>();
	public static List<Address> addList = new LinkedList<Address>();

//	public static <T> void upload(File file, T student) throws IOException {
	public static void uploadStudent(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";

		// skipping the first line
		line = br.readLine();
		   while ((line = br.readLine()) != null) {
			String[] studentArr = line.split(",");
			Student student1 = new Student();
			student1.setId(Integer.parseInt(studentArr[0]));
			student1.setName(studentArr[1]);
			student1.setClass_id(Integer.parseInt(studentArr[2]));
			student1.setMarks(Integer.parseInt(studentArr[3]));
			student1.setGender(studentArr[4].toCharArray()[0]);
			student1.setAge(Integer.parseInt(studentArr[5]));
			studentList.add(student1);
		   }

//		studentList.stream().forEach(System.out::println);

		br.close();
	}
	public static void uploadClass(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));

		// skipping the first line
		String line = br.readLine();

		while ((line = br.readLine()) != null) {
			String[] classArr = line.split(",");
			Classes classes = new Classes();
			classes.setId(Integer.parseInt(classArr[0]));
			classes.setName(classArr[1].toCharArray()[0]);
			classList.add(classes);
		}
//		classList.stream().forEach(System.out::println);
		br.close();
	}
	
	public static void uploadAddress(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));

		// skipping the first line
		String line = br.readLine();

		while ((line = br.readLine()) != null) {
			String[] addArr = line.split(",");
			Address add = new Address();
			add.setId(Integer.parseInt(addArr[0]));
			add.setPin_code(Integer.parseInt(addArr[1]));
			add.setCity(addArr[2]);
			add.setStudent_id(Integer.parseInt(addArr[3]));
			addList.add(add);
		}

//		addList.stream().forEach(System.out::println);
		br.close();
	}
	 
	//1
	 public static List<Student> getByPincode(Long pincode,Character gender,Integer age,Integer classes)
	 {
		 return addList.stream().
				 filter(e->e.getPin_code()==pincode)
				 .flatMap(add -> studentList.stream()
		                    .filter(student -> student.getId() == add.getStudent_id() &&
		                                       student.getGender() == gender &&
		                                       student.getAge() < age &&
		                                       student.getClass_id() == classes))
		            .collect(Collectors.toList());
				 
	 }
	 
	 public static List<Student> getByCity(String city,Character gender,Integer age,Integer classes)
	 {
		 return addList.stream()
				 .filter(e->e.getCity().equals(city))
				 .flatMap(add->studentList.stream().filter(student->student.getId()==add.getStudent_id() &&
				    student.getGender()==gender &&
				    student.getAge()<age &&
				    student.getClass_id()==classes))
				 .collect(Collectors.toList());
	 }
	 public static String deleteStudent(Integer student_id) {
			int originalSize = studentList.size();

			studentList = studentList.stream().filter(s -> s.getId() != student_id).collect(Collectors.toList());
			addList = addList.stream().filter(s -> s.getStudent_id() != student_id).collect(Collectors.toList());

			int newSize = studentList.size();

			if (newSize != originalSize) {
				return "Student Deleted";
			} else
				return "Student Does Not Exist";
		}
	 static int zeroId = 0;
	 public static String deleteClass() {
			Map<Integer, Integer> studentsByClassId = new HashMap<Integer, Integer>();

			classList.stream().forEach(c -> {
				studentsByClassId.put(c.getId(), 0);
			});

			studentList.stream().forEach(c -> {
				studentsByClassId.put(c.getClass_id(), studentsByClassId.getOrDefault(c.getClass_id(), 0) + 1);
			});
			
			zeroId = studentsByClassId.entrySet().stream().filter(e->e.getValue().equals(0)).map(Map.Entry::getKey).findFirst().get();
			Character className = classList.stream().filter(c->c.getId()==zeroId).findFirst().map(Classes::getName).get();
			classList = classList.stream().filter(c -> c.getId() != zeroId).collect(Collectors.toList());
			if (zeroId != 0)
				return className+ " Class Deleted";
			return "CLass Not Deleted";
	 }
	 public static List<Student> getSortedStudentByOrder(List<Student> studList, Character gender, int start, int end,
				String sortBy, boolean ReverseOrder) {
			Comparator<Student> comparator = getComparator(sortBy, ReverseOrder);
			return studList.stream().filter(s -> s.getGender().equals(gender)).sorted(comparator).skip(start - 1).limit(end)
					.collect(Collectors.toList());
		}

		public static Comparator<Student> getComparator(String sortBy, boolean reverseOrder) {
			Comparator<Student> comparator = null;

			switch (sortBy) {
			case "name":
				comparator = Comparator.comparing(Student::getName);
				if(reverseOrder==true)
					comparator = Comparator.comparing(Student::getName).reversed();
				break;
			case "marks":
				comparator = Comparator.comparing(Student::getMarks);
				if(reverseOrder==true)
					comparator = Comparator.comparing(Student::getMarks).reversed();
				break;
			case "class_id":
				comparator = Comparator.comparing(Student::getClass_id);
				if(reverseOrder==true)
					comparator = Comparator.comparing(Student::getClass_id).reversed();
				break;
			default:
				comparator = Comparator.comparing(Student::getId);
				if(reverseOrder==true)
					comparator = Comparator.comparing(Student::getId).reversed();
			}
			return comparator;
		}


	public static void main(String[] args)throws IOException {
		uploadStudent(new File("C:\\Users\\hp\\Documents\\Student.csv"));
		uploadClass(new File("C:\\Users\\hp\\Documents\\Class.csv"));
		uploadAddress(new File("C:\\Users\\hp\\Documents\\Address.csv"));
		//1.
		//getByPincode(452002l, 'F', 45, 1).forEach(System.out::println);
		
		//2.
		//getByCity("indore",'F', 45, 1).forEach(System.out::println);
		
		//3
		//List<Student> studRank=Ranking.ranking(studentList);
	    //studRank.forEach(System.out::println);
		
		//4
        //System.out.println("Passed students");
	    //List<Student> passedStudent = Passed.getPass(studentList, 'F', 50, 1, "indore",452002L);
		//passedStudent.forEach(System.out::println);
		
		//5
		//System.out.println("failed student");
		//List<Student> failedStudent = FailedStudent.getFailStudent(studentList, 'F', 35, 3, "mumbai", 482002L);
		//failedStudent.forEach(System.out::println);
		//6
		//System.out.println("class id student");
		//List<Student> classStudent = ClassStudent.getStudentByClass(studentList, 'A', 'F', 35, "indore", 452002L);
		//classStudent.forEach(System.out::println);
		
		//7
		//List<Student> failedStudentByAge = Ranking.failStudentByAge(20);		
		//studentList.forEach(System.out::println);
		
		//8
		//System.out.println(deleteStudent(1));
		//addList.forEach(System.out::println);
		
		//9
		//System.out.println(deleteClass());
		//classList.forEach(System.out::println);
		
		//10
		getSortedStudentByOrder(studentList, 'F', 1, 4, "name", true).forEach(System.out::println);

	}

}
