package services;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import abonnements.AbonnementsTo16and12Times;
import decorator.Price;
import eleks.sportclub.Client;
import eleks.sportclub.Gender;
import eleks.sportclub.helpful.SqlDate;

public class AttendingGymTest {
	private Price price;
	private Client client;
	
	@Before
	public void setUp() throws Exception {
		price = new AbonnementsTo16and12Times();
		client = new Client("Lotockiy", "Roman", 35, SqlDate.createSqlDate("10-11-1981"),
				"Lviv", Gender.MAN, false, SqlDate.createSqlDate("02-07-2016"));
	}

	@Test
	public void test() throws ParseException {
		client.setPrice(price);
		price = new AttendingGym(price);
		System.out.println(price.getPrice() + "\n" + price.getDescription());
	}

}
