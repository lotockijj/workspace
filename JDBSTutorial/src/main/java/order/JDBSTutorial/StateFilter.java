package order.JDBSTutorial;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.Predicate;

public class StateFilter implements Predicate {

  private int lo;
  private int hi;
  private String colName = null;
  private int colNumber = -1;

  public StateFilter(int lo, int hi, int colNumber) {
    this.lo = lo;
    this.hi = hi;
    this.colNumber = colNumber;
  }

  public StateFilter(int lo, int hi, String colName) {
    this.lo = lo;
    this.hi = hi;
    this.colName = colName;
  }

  public boolean evaluate(Object value, String columnName) {

    boolean evaluation = true;
    if (columnName.equalsIgnoreCase(this.colName)) {
      int columnValue = ((Integer)value).intValue();
      if ((columnValue >= this.lo) && (columnValue <= this.hi)) {
        evaluation = true;
      } else {
        evaluation = false;
      }
    }
    return evaluation;
  }

  public boolean evaluate(Object value, int columnNumber) {

    boolean evaluation = true;
    if (this.colNumber == columnNumber) {
      int columnValue = ((Integer)value).intValue();
      if ((columnValue >= this.lo) && (columnValue <= this.hi)) {
        evaluation = true;
      } else {
        evaluation = false;
      }
    }
    return evaluation;
  }


  public boolean evaluate(RowSet rs) {

    CachedRowSet frs = (CachedRowSet)rs;
    boolean evaluation = false;
    try {
      int columnValue = -1;

      if (this.colNumber > 0) {
        columnValue = frs.getInt(this.colNumber);
      } else if (this.colName != null) {
        columnValue = frs.getInt(this.colName);
      } else {
        return false;
      }

      if ((columnValue >= this.lo) && (columnValue <= this.hi)) {
        evaluation = true;
      }
    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
      return false;
    } catch (NullPointerException npe) {
      System.out.println("NullPointerException caught");
      return false;
    }
    return evaluation;
  }
}
