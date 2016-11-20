package order.JDBSTutorial;

import com.sun.rowset.CachedRowSetImpl;

import com.sun.rowset.JoinRowSetImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;

public class JoinSample {
  
  Connection con;
  JDBCTutorialUtilities settings;  
  
  public JoinSample(Connection connArg, JDBCTutorialUtilities settingsArg) {
    this.con = connArg;
    this.settings = settingsArg;
  }

  public static void getCoffeesBoughtBySupplier(String supplierName,
                                                Connection con) throws SQLException {
    Statement stmt = null;
    String query =
      "SELECT COFFEES.COF_NAME " + "FROM COFFEES, SUPPLIERS " + "WHERE SUPPLIERS.SUP_NAME LIKE '" +
      supplierName + "' " + "and SUPPLIERS.SUP_ID = COFFEES.SUP_ID";

    try {
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      System.out.println("Coffees bought from " + supplierName + ": ");
      while (rs.next()) {
        String coffeeName = rs.getString(1);
        System.out.println("     " + coffeeName);
      }
    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    } finally {
      if (stmt != null) { stmt.close(); }
    }
  }
  
  public void testJoinRowSet(String supplierName) throws SQLException {
    
    CachedRowSet coffees = null;
    CachedRowSet suppliers = null;
    JoinRowSet jrs = null;
    
    try {
      coffees = new CachedRowSetImpl();
      coffees.setCommand("SELECT * FROM COFFEES");
      coffees.setUsername(settings.userName);
      coffees.setPassword(settings.password);
      coffees.setUrl(settings.urlString);
      coffees.execute();
      
      suppliers = new CachedRowSetImpl();
      suppliers.setCommand("SELECT * FROM SUPPLIERS");
      suppliers.setUsername(settings.userName);
      suppliers.setPassword(settings.password);
      suppliers.setUrl(settings.urlString);
      suppliers.execute();      
      
      jrs = new JoinRowSetImpl();
      jrs.addRowSet(coffees, "SUP_ID");
      jrs.addRowSet(suppliers, "SUP_ID");
      
      
      System.out.println("Coffees bought from " + supplierName + ": ");
      while (jrs.next()) {
        if (jrs.getString("SUP_NAME").equals(supplierName)) { 
          String coffeeName = jrs.getString(1);
          System.out.println("     " + coffeeName);
        }
      }
    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    } finally {
      if (jrs != null) { jrs.close(); }
      if (suppliers != null) { suppliers.close(); }
      if (coffees != null) { coffees.close(); }
    }
  }


  public static void main(String[] args) {
    JDBCTutorialUtilities myJDBCTutorialUtilities;
    Connection myConnection = null;
    if (args[0] == null) {
      System.err.println("Properties file not specified at command line");
      return;
    } else {
      try {
        myJDBCTutorialUtilities = new JDBCTutorialUtilities(args[0]);
      } catch (Exception e) {
        System.err.println("Problem reading properties file " + args[0]);
        e.printStackTrace();
        return;
      }
    }

    try {
      myConnection = myJDBCTutorialUtilities.getConnection();

      System.out.println("\nCoffees bought by each supplier:");
      JoinSample.getCoffeesBoughtBySupplier("Acme, Inc.", myConnection);

      System.out.println("\nUsing JoinRowSet:");
      JoinSample myJoinSample = new JoinSample(myConnection, myJDBCTutorialUtilities);
      myJoinSample.testJoinRowSet("Acme, Inc.");

    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    } finally {
      JDBCTutorialUtilities.closeConnection(myConnection);
    }

  }
}
