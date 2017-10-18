package lambda;

import lambda.Person.Sex;

public class CheckPerson implements Check{

	public boolean test(Person p) {
		return p.getGender() == Sex.MALE && p.getAge() < 30 && p.getAge() > 20;
	}

}
