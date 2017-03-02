package gui;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dao.UserDAO;

public class AuditHistoryDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try{
			AuditHistoryDAO auditHistoryDao = new AuditHistoryDAO();
			List<UsersHistory> listAuditHistory = auditHistoryDao.getTheWholeAuditHistory();
			assertTrue(listAuditHistory.size() == 9);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e2){
			e2.printStackTrace();
		} catch (IOException e3){
			e3.printStackTrace();
		}
	}

}
