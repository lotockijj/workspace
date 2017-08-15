package abonnements;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import eleks.sportclub.helpful.SqlDate;
import junit.framework.Assert;

public class AbonnementsAllDay12TimesTest {
	private BigDecimal cost;
	private AbonnementsAllDay12Times ab;
	private Date startDate;
	
	@Before
	public void setUp() throws Exception {
		cost = new BigDecimal(420);
		ab = new AbonnementsAllDay12Times();
	}

	@Test
	public void testAbonnementsAllDay12Times() {
		Assert.assertNotNull(ab.getTrack());
		Assert.assertEquals(cost, ab.getPrice());
	}
	
	@Test 
	public void testGetTrack(){
		Assert.assertTrue(ab.getTrack().isBaseAllDay());
		Assert.assertFalse(ab.getTrack().isBase());
		Assert.assertFalse(ab.getTrack().isBaseAllDayUnlimited());
		Assert.assertFalse(ab.getTrack().isBaseUnlimited());
	}
	
	@Test
	public void testGetDescription(){
		String expected = "Зал(весь день) 12 разів: "  + cost + " гривень.\n";
		Assert.assertEquals(expected, ab.getDescription());
	}
	
	@Test
	public void testGetPrice(){
		Assert.assertEquals(cost, ab.getPrice());
	}
	
	@Test
	public void testSetPriceStartDateMoreThen10Years() throws ParseException{
		startDate = SqlDate.createSqlDate("02-08-2006");
		ab.setPrice(startDate);
		Assert.assertEquals(398.99, ab.getPrice().doubleValue());
	}
	
	@Test
	public void testSetPriceStartDateLessThen10Years() throws ParseException{
		startDate = SqlDate.createSqlDate("02-08-2016");
		ab.setPrice(startDate);
		System.out.println(ab.getPrice());
		Assert.assertEquals(new Double(420), ab.getPrice().doubleValue());
	}

}
