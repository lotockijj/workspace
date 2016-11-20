package order.JDBSTutorial;




import com.sun.rowset.WebRowSetImpl;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class WebRowSetSample {
  
  private String dbName;
  private Connection con;
  private String dbms;
  private JDBCTutorialUtilities settings;
  
  public WebRowSetSample(Connection connArg, JDBCTutorialUtilities settingsArg) {
    super();
    this.con = connArg;
    this.dbName = settingsArg.dbName;
    this.dbms = settingsArg.dbms;
    this.settings = settingsArg;
  }
  
  public void testWebRowSet() throws SQLException, IOException {
      FileReader fReader = null;
      FileWriter fWriter = null;
      String priceListFileName = "pricelist.xml";
    int [] keyCols = {1};
    WebRowSet priceList = new WebRowSetImpl();
    
    priceList.setUsername(settings.userName);
    priceList.setPassword(settings.password);
    priceList.setUrl(settings.urlString);
    priceList.setCommand("select COF_NAME, PRICE from COFFEES");
    priceList.setKeyColumns(keyCols);

    // Populate the WebRowSet
    priceList.execute();
    System.out.println("Size of the WebRowSet is: " + priceList.size());
   
    // Insert a new row
    priceList.moveToInsertRow();
    priceList.updateString("COF_NAME", "Kona");
    priceList.updateFloat("PRICE", 8.99f);
    priceList.insertRow();
    priceList.moveToCurrentRow();
    System.out.println("New row inserted");
    System.out.println("Size of the WebRowSet is: "+priceList.size());
    
    //Delete the row with "Espresso"
    priceList.beforeFirst();
    while(priceList.next()) {
      if(priceList.getString(1).equals( "Espresso" )) {
        System.out.println( "Deleting row with Espresso..." );
        priceList.deleteRow();
        break;
      }
    }
    
    // Update price of Colombian
    priceList.beforeFirst();
    while(priceList.next()) {
      if(priceList.getString(1).equals("Colombian")) {
        System.out.println("Updating row with Colombian...");
        priceList.updateFloat(2, 6.99f);
        priceList.updateRow();
        break;
      }
    }
    
    int size1 = priceList.size();
    fWriter = new FileWriter( priceListFileName );
    priceList.writeXml(fWriter);
    fWriter.flush();
    fWriter.close();
    
    // Create the receiving WebRowSet object
    WebRowSet receiver = new WebRowSetImpl();
    receiver.setUrl(settings.urlString);
    receiver.setUsername(settings.userName);
    receiver.setPassword(settings.password);
    
    //Now read the XML file.
    fReader = new FileReader( priceListFileName );
    receiver.readXml(fReader);
    int size2 = receiver.size();
    if (size1 == size2) {
      System.out.println( "WebRowSet serialized and " +
      "deserialiazed properly" );
    } else {
      System.out.println("Error....serializing/deserializng the WebRowSet");
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

      // Java DB does not have an SQL create database command; it does require createDatabase
      
      
      WebRowSetSample myWebRowSetSample = new WebRowSetSample(myConnection,
                                           myJDBCTutorialUtilities);
      myWebRowSetSample.testWebRowSet();   

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
