package db;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueryDBTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		QueryDB queryDB = new QueryDB();
		queryDB.createQuery();
	}

}
