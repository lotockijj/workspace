package main.java.database;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;



	/**
	 * 
	 */

public class ConnectionPoolingBean<ds> implements SessionBean{

	private static final long serialVersionUID = 1L;
	private InitialContext ctx;
	private DataSource ds;

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public void ejbCreate()throws CreateException, NamingException{
		ctx = new InitialContext();
		ds = (DataSource) ctx.lookup("jdbc/employees");
	}
	
	public void updatePrice(float price, String cofName, String username,
			String password) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt;
		try{
			con = ds.getConnection(username, password);
			con.setAutoCommit(false);
			pstmt = con.prepareStatement("UPDATE EMPLOYEES" 
					+ "SET PRICE = ?" 
					+ "WHERE COF_NAME = ?");
			pstmt.setFloat(1, price);
			pstmt.setString(2, cofName);
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
		} finally {
			if(con != null) con.close();
		}
	}
//	private DataSource ds = null;
//	private Context ctx = null;

}
