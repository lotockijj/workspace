package designpatterns.thirteen.simple;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testng.Assert;

public class PersonDeepCopyTest {

	@Test
	public void test() {
		PersonDeepCopy person = new PersonDeepCopy("Kolya", "Civic");
		PersonDeepCopy personClone = (PersonDeepCopy) person.clone();
		personClone.setName("Taras");
		personClone.getCar().setName("Honda");
		Assert.assertFalse(personClone.getCar().getName() == person.getCar().getName());
	} 

}
