package order.JDBSTutorial;

import com.sun.rowset.JdbcRowSetImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;

public class JdbcRowSetSample {

  private String dbName;
  private Connection con;
  private String dbms;
  private JDBCTutorialUtilities settings;

  public JdbcRowSetSample(Connection connArg,
                          JDBCTutorialUtilities settingsArg) {
    super();
    this.con = connArg;
    this.dbName = settingsArg.dbName;
    this.dbms = settingsArg.dbms;
    this.settings = settingsArg;
  }

  public void testJdbcRowSet() throws SQLException {

    JdbcRowSet jdbcRs = null;
    ResultSet rs = null;
    Statement stmt = null;

    try {
      
        // An alternative way to create a JdbcRowSet object
      
//      stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//      rs = stmt.executeQuery("select * from COFFEES");
//      jdbcRs = new JdbcRowSetImpl(rs);
     
        // Another way to create a JdbcRowSet object
       
//      jdbcRs = new JdbcRowSetImpl();
//      jdbcRs.setCommand("select * from COFFEES");
//      jdbcRs.setUrl(this.settings.urlString);
//      jdbcRs.setUsername(this.settings.userName);
//      jdbcRs.setPassword(this.settings.password);
//      jdbcRs.execute();
      
      jdbcRs = new JdbcRowSetImpl(con);
      jdbcRs.setCommand("select * from COFFEES");
      jdbcRs.execute();
      
      jdbcRs.absolute(3);
      jdbcRs.updateFloat("PRICE", 10.99f);
      jdbcRs.updateRow();

      System.out.println("\nAfter updating the third row:");
      CoffeesTable.viewTable(con);

      jdbcRs.moveToInsertRow();
      jdbcRs.updateString("COF_NAME", "HouseBlend");
      jdbcRs.updateInt("SUP_ID", 49);
      jdbcRs.updateFloat("PRICE", 7.99f);
      jdbcRs.updateInt("SALES", 0);
      jdbcRs.updateInt("TOTAL", 0);
      jdbcRs.insertRow();

      jdbcRs.moveToInsertRow();
      jdbcRs.updateString("COF_NAME", "HouseDecaf");
      jdbcRs.updateInt("SUP_ID", 49);
      jdbcRs.updateFloat("PRICE", 8.99f);
      jdbcRs.updateInt("SALES", 0);
      jdbcRs.updateInt("TOTAL", 0);
      jdbcRs.insertRow();

      System.out.println("\nAfter inserting two rows:");
      CoffeesTable.viewTable(con);

      jdbcRs.last();
      jdbcRs.deleteRow();

      System.out.println("\nAfter deleting last row:");
      CoffeesTable.viewTable(con);


    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    }

    finally {
      if (stmt != null) stmt.close();
      this.con.setAutoCommit(false);
    }
  }
  
  private void outputRowSet(RowSet rs) throws SQLException {
    rs.beforeFirst();
    while (rs.next()) {
      String coffeeName = rs.getString(1);
      int supplierID = rs.getInt(2);
      float price = rs.getFloat(3);
      int sales = rs.getInt(4);
      int total = rs.getInt(5);
      System.out.println(coffeeName + ", " + supplierID + ", " + price +
                         ", " + sales + ", " + total);
      
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

      JdbcRowSetSample myJdbcRowSetSample =
        new JdbcRowSetSample(myConnection, myJDBCTutorialUtilities);
      myJdbcRowSetSample.testJdbcRowSet();


    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    } finally {
      JDBCTutorialUtilities.closeConnection(myConnection);
    }

  }

}
