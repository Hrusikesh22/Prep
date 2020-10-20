package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://stackify.com/streams-guide-java-8/
// https://mkyong.com/java8/java-8-flatmap-example/

public class StreamExamples {

	public static void main(String[] str) {
		
		Employee[] arrayOfEmps = {new Employee(1, "Jeff Bezos", 100000), new Employee(2, "Bill Gates", 200000), new Employee(3, "Mark Zuckerberg", 300000) };
		
		ways2CreateStreamAndOperate(arrayOfEmps);
		
	}
	
	static void ways2CreateStreamAndOperate(Employee[] arrayOfEmps) {

		Stream<Employee> empStream = Stream.of(arrayOfEmps);//1
		empStream = Arrays.asList(arrayOfEmps).stream();//2
		empStream = Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);//3
		
		Stream.Builder<Employee> streamBldr = Stream.builder();
		streamBldr.accept(arrayOfEmps[0]);
		streamBldr.accept(arrayOfEmps[1]);
		streamBldr.accept(arrayOfEmps[2]);
		
		empStream = streamBldr.build();
		
		/** stream.forEach : It's a terminating operation **/
		empStream.forEach(emp -> System.out.println(emp));			//1
		empStream.forEach(System.out::println);							//2
		
		/** stream.collect, stream.map **/
		List<Employee> empList = empStream.collect(Collectors.toList());//1
		empList = empStream.map(EmployeeRepo :: findById).collect(Collectors.toList());//2
		
		/** stream.filter **/
		empList = empStream.map(EmployeeRepo :: findById)
				.filter(emp->emp.sal>10000)
				.collect(Collectors.toList());

		Employee e = empStream.map(EmployeeRepo :: findById)
					.filter(emp->emp.sal>10000)
					.findFirst()
					.orElse(null);//Can return a default employee too.
		
		//findFirst() is a SHORT-CIRCUIT OPERATION. Once found first element, stops processing further.
		//i.e. checks sal>10000, once found one such employee, return. Won't process remaining elements in the stream
		
		/** stream.toArray **/
		Employee[] empArr = empStream.toArray(Employee[]::new);
		
		/** stream.distinct **/
	    List<Integer> distinctIntList = Arrays.asList(2, 5, 3, 2, 4, 3).stream().distinct().collect(Collectors.toList());
	    
	    /** stream.sort **/
	    empList = empStream
	    		.sorted((e1, e2) -> e1.name.compareTo(e2.name))
	    		.collect(Collectors.toList());
	    
	    /** stream.min/max **/
	    //In case of stream.sort, if we use short-circuit operation like findFirst, still it will execute for all elements,
	    //as it has to decide like findFirst (or to find Min, Max etc.)
	    e = empStream
	    	.min((e1, e2) -> e1.id - e2.id) //Comparator passed.
	    	.orElseThrow(NoSuchElementException::new);//If not found, returns Optional object as exception
	    e = empStream
	    	.max(Comparator.comparing(emp->emp.sal))//Used Comparator.comparing() instead of passing user-defined comparator.
	    	.orElseThrow(NoSuchElementException::new);
	    
	    /** stream.allMatch/anyMatch/noneMatch **/
	    //All are short-circuit operations. So checks for success/failure, accordingly terminates/short-circuit happens for better perf.
	    Arrays.asList(2, 5, 3, 2, 4, 3).stream().allMatch(i -> i%2==0);//All should match, for any mis-match<=short-circuit
	    
	    /** Advanced collect **/
	    empStream.map(Employee::getName).collect(Collectors.joining(", ")).toString();//Joining
	    empStream.map(Employee::getName).collect(Collectors.toSet());//toSet
	    empStream.map(Employee::getName).collect(Collectors.toCollection(ArrayList::new));//toCollection
	    empStream.collect(Collectors.partitioningBy(emp -> emp.getSal()>10000));//partitioningBy - returns map of 2 partitions.
	    Map<Long, List<Employee>> EmployeesBySal = empStream.collect(Collectors.groupingBy(emp->emp.sal));//groupingBy
		
	}
}

class Employee {
	int id; String name; long sal;
	
	public int getId() { return id; }
	public String getName() { return name; }
	public long getSal() { return sal; }

	public Employee(int id, String name, long sal) {
		this.id = id; this.name = name; this.sal = sal;
	}
}

class EmployeeRepo {
	static Employee findById(Employee emp){return null;}
}