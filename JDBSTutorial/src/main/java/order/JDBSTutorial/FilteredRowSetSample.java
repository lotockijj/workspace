package order.JDBSTutorial;

import com.sun.rowset.CachedRowSetImpl;

import com.sun.rowset.FilteredRowSetImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;

public class FilteredRowSetSample {
  private String dbName;
  private Connection con;
  private String dbms;
  private JDBCTutorialUtilities settings;


  public FilteredRowSetSample(Connection connArg,
                              JDBCTutorialUtilities settingsArg) {
    super();
    this.con = connArg;
    this.dbName = settingsArg.dbName;
    this.dbms = settingsArg.dbms;
    this.settings = settingsArg;
  }

  private void viewFilteredRowSet(FilteredRowSet frs) throws SQLException {

    if (frs == null) {
      return;
    }

    CachedRowSet crs = (CachedRowSet)frs;

    while (crs.next()) {
      if (crs == null) {
        break;
      }
      System.out.println(
        crs.getInt("STORE_ID") + ", " +
        crs.getString("CITY") + ", " +
        crs.getInt("COFFEE") + ", " +
        crs.getInt("MERCH") + ", " +
        crs.getInt("TOTAL"));
    }
  }

  public static void viewTable(Connection con) throws SQLException {
    Statement stmt = null;
    String query = "select * from COFFEE_HOUSES";
    try {
      stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
        System.out.println(rs.getInt("STORE_ID") + ", " +
                           rs.getString("CITY") + ", " + rs.getInt("COFFEE") +
                           ", " + rs.getInt("MERCH") + ", " +
                           rs.getInt("TOTAL"));
      }

    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    } finally {
      if (stmt != null) { stmt.close(); }
    }
  }

  public void testFilteredRowSet() {
    FilteredRowSet frs = null;
    StateFilter myStateFilter = new StateFilter(10000, 10999, 1);
    String[] cityArray = { "SF", "LA" };

    CityFilter myCityFilter = new CityFilter(cityArray, 2);

    try {
      frs = new FilteredRowSetImpl();

      frs.setCommand("SELECT * FROM COFFEE_HOUSES");
      frs.setUsername(settings.userName);
      frs.setPassword(settings.password);
      frs.setUrl(settings.urlString);
      frs.execute();

      System.out.println("\nBefore filter:");
      FilteredRowSetSample.viewTable(this.con);

      System.out.println("\nSetting state filter:");
      frs.beforeFirst();
      frs.setFilter(myStateFilter);
      this.viewFilteredRowSet(frs);

      System.out.println("\nSetting city filter:");
      frs.beforeFirst();
      frs.setFilter(myCityFilter);
      this.viewFilteredRowSet(frs);


    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
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
      FilteredRowSetSample myFilteredRowSetSample =
        new FilteredRowSetSample(myConnection, myJDBCTutorialUtilities);
      myFilteredRowSetSample.testFilteredRowSet();
    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    } catch (Exception ex) {
      System.out.println("Unexpected exception");
      ex.printStackTrace();
    }

    finally {
      JDBCTutorialUtilities.closeConnection(myConnection);
    }
  }
}
