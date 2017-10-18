package lambda;

import java.util.ArrayList;
import java.util.List;

public class Accountant {

	public static List<Person> printPerson(List<Person> list, int age){
		List<Person> resultList = new ArrayList<>();
		for(Person p : list){
			if(p.getAge() > age){
				resultList.add(p);
			}
		}
		return resultList;
	}
	
	public static List<Person> printPersonsWithinAgeRange(List<Person> list, int low, int high){
		List<Person> resultList = new ArrayList<>();
		for(Person p : list){
			if(low <= p.getAge() && p.getAge() < high){
				resultList.add(p);
			}
		}
		return resultList;
	}
	
	public static List<Person> printPersonsChecker(List<Person> list, Check tester){
		List<Person> resultList = new ArrayList<>();
		for(Person p : list){
			if(tester.test(p)){
				resultList.add(p);
			}
		}
		return resultList;
	}
}
