package yakov.fain.lesson15;

import java.util.ArrayList;
import java.util.List;

import yakov.fain.lesson7tryit.Employee;

public class TestGenericMethod {
	
	public static void main(String[] args) {
		
		List<RetiredEmployee> retiredEmployee = new ArrayList<>();
		
		retiredEmployee.add(new RetiredEmployee("Mary Ann"));
		retiredEmployee.add(new RetiredEmployee("Stive Jobson"));
		retiredEmployee.add(new RetiredEmployee("John Smith"));
		
		List<Employee> empl = new ArrayList<>();
		empl.addAll(retiredEmployee);
		
		for(Employee ret : empl){
			System.out.println(ret.getName());
		}
	
	}
}
