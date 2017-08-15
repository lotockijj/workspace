package eleks.sportclub.helpful;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import abonnements.AbonnementsTo16and12Times;
import decorator.Price;
import eleks.sportclub.Client;
import eleks.sportclub.Gender;
import junit.framework.Assert;
import services.AttendingGym;
import services.Fresh;
import services.GeneralMassage;
import services.Krosfit;
import services.OneTimeSlippers;
import services.Sauna;
import services.Solarium;
import services.Towel;
import services.Yoga;

public class GymTest {
	Client client;
	Price price; 
	
	@Before
	public void setUp() throws Exception {
		client = new Client("Lotockiy", "Roman", 35, SqlDate.createSqlDate("10-11-1981"),
				"Lviv", Gender.MAN, false, SqlDate.createSqlDate("02-09-2016"));
		price = new AbonnementsTo16and12Times();
	}

	@Test
	public void test() {
		client.setPrice(price);
		Assert.assertEquals(new BigDecimal("390"), price.getPrice());
		price = new AttendingGym(price);
		Assert.assertEquals(new BigDecimal("425"), price.getPrice());
		price = new Fresh(price);
		Assert.assertEquals(new BigDecimal("475"), price.getPrice());
		price = new GeneralMassage(price);
		Assert.assertEquals(new BigDecimal("675"), price.getPrice());
		price = new Krosfit(price);
		Assert.assertEquals(new BigDecimal("705"), price.getPrice());
		price = new OneTimeSlippers(price);
		Assert.assertEquals(new BigDecimal("710"), price.getPrice());
		price = new Sauna(price);
		Assert.assertEquals(new BigDecimal("1110"), price.getPrice());
		price = new Solarium(price);
		Assert.assertEquals(new BigDecimal("1260"), price.getPrice());
		price = new Towel(price);
		Assert.assertEquals(new BigDecimal("1265"), price.getPrice());
		price = new Yoga(price);
		Assert.assertEquals(new BigDecimal("1300"), price.getPrice());
		System.out.println(client.getLastName() + " " + client.getFirstName() + "\n" + 
				"Price: " + client.getPrice().getPrice() +
				"\nDescription: " + price.getDescription() + 
				"\nThe whole price: " + price.getPrice());
	}

}
