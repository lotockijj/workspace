package order.JDBSTutorial;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class ExampleRowSetListener implements RowSetListener {

  public void rowSetChanged(RowSetEvent event) {
    System.out.println("Called rowSetChanged in ExampleRowSetListener");
  }

  public void rowChanged(RowSetEvent event) {
    System.out.println("Called rowChanged in ExampleRowSetListener");
  }

  public void cursorMoved(RowSetEvent event) {
    System.out.println("Called cursorMoved in ExampleRowSetListener");
  }
}
