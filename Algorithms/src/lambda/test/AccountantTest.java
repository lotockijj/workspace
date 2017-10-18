package lambda.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lambda.Accountant;
import lambda.CheckPerson;
import lambda.Person;
import lambda.Person.Sex;

public class AccountantTest {
	private List<Person> persons;
	private CheckPerson tester;

	@Before
	public void setUp() throws Exception {
		persons = new ArrayList<>();
		persons.add(new Person("Roman", LocalDate.of(1981, 10, 11),
				Sex.MALE, "lotockijj-roman@rambler.ru"));
		persons.add(new Person("Nataly", LocalDate.of(1986, 11, 10),
				Sex.FEMALE, "nataly@com.ua"));
		persons.add(new Person("Vitalic", LocalDate.of(1991, 10, 11),
				Sex.MALE, "vitalick@com.ua"));
		persons.add(new Person("Kolya", LocalDate.of(1981, 8, 31),
				Sex.MALE, "kolya@com.usa"));
		tester = new CheckPerson();
	}

	@Test
	public void testPrintPerson() {
		Assert.assertEquals(2, Accountant.printPerson(persons, 35).size());
		Assert.assertEquals(3, Accountant.printPerson(persons, 27).size());
	}

	@Test
	public void testPrintPersonsWithinRange(){
		Assert.assertEquals(2, Accountant.printPersonsWithinAgeRange(persons, 34, 40).size());
		Assert.assertEquals(1, Accountant.printPersonsWithinAgeRange(persons, 25, 27).size());
	}

	@Test
	public void testWithClassCheckPerson(){
		Assert.assertEquals(1, Accountant.printPersonsChecker(persons, tester).size());
		List<Person> list = Accountant.printPersonsChecker(persons, new CheckPerson(){
			public boolean test(Person p) {
				return p.getGender() == Sex.FEMALE;
			}
		});
		Assert.assertEquals(1, list.size());
	}

	@Test
	public void testLambda(){
		List<Person> list = Accountant.printPersonsChecker(persons, 
				(Person p) -> p.getGender() == Sex.FEMALE 
				&& p.getAge() > 30
				&& p.getAge() <=31
				);
		Assert.assertEquals(1, list.size());
		System.out.println(persons.stream().findFirst());
		persons.stream().filter(p -> p.getGender() == Sex.FEMALE).forEach(e -> 
		System.out.println(e.getName() + ". Age: " + e.getAge()));
		persons.parallelStream().filter(p -> p.getGender() == Sex.MALE).forEach(e -> 
		System.out.println(e.getName()));
	}

}
