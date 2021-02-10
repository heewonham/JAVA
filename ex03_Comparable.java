package cse3040_18;

import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee>{
	private String name;
	private int salary;
	public Employee(String name, int salary) { this.name = name; this.salary = salary; }
	public String getName() { return this.name; }
	public int getSalary() { return this.salary; }
	
	public int compareTo(Employee e) {
		if(this.salary > e.getSalary()) return -1;
		if(this.salary < e.getSalary()) return 1;
		return this.name.compareTo(e.getName());
	}
	public String toString() { return this.name + " " + this.salary; }
} 
public class ex03_Comparable {

	public static void main(String[] args) {
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		emplist.add(new Employee("Peter", 50000));
		emplist.add(new Employee("John", 100000));
		emplist.add(new Employee("Robert", 100000));
		System.out.println(emplist);
		Collections.sort(emplist);
		System.out.println(emplist);
	}
}
