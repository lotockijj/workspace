package designpatterns.thirteen.simple;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
		Person person = new Person("Kolya", "Civic");
		Person personClone = (Person) person.clone();
		personClone.setName("Taras");
		Assert.assertEquals("Kolya", person.getName());
		Assert.assertEquals("Taras", personClone.getName());
		
		personClone.getCar().setName("Honda");
		
		Assert.assertTrue(person.getCar() == personClone.getCar());
	}

}
