import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<String, Student> map = new HashMap<>();
		map.put("1", new Student("dbc", 10));
		map.put("2", new Student("abc", 15));
		Collection<Student> students =  map.values();
		students.sor
		for(Student student : students) {
			System.out.println(student.name + " " + student.age);
		}
	}
	
	
}

class Student {
	String name;
	int age;
	Student(String name, int age){
		this.name = name;
		this.age = age;
	}
}
