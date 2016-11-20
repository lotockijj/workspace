package yakov.fain.lesson23;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class MyFrame  extends JFrame implements TableModelListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyTableModel myTableModel;
	private JTable myTable;

	MyFrame (String winTitle){
		super(winTitle);
		myTableModel = new MyTableModel();
		myTable = new JTable(myTableModel);
		//Add the JTable to frame and enable scrolling 
		add(new JScrollPane(myTable));
		// Register an event listener
		myTableModel.addTableModelListener(this);
		// Custom cell rendering of the Price value
		//Assign custom cell renderer to the Price column, get the reference to the fourth column - Price
		TableColumn column = myTable.getColumnModel().getColumn(3);
		//Create a new cell renderer as an anonymous inner class and assign it to the column price
		column.setCellRenderer(
				new DefaultTableCellRenderer(){
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected, 
							boolean hasFocus, int row, int column){
						JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
						//right-align the price value
						label.setHorizontalAlignment(JLabel.RIGHT);
						//display stocks that cost more than $100 in red
						if(((Float) value) > 100){
							label.setForeground(Color.RED);
						} else {
							label.setForeground(Color.BLACK);
						}
						return label;
					}
				});

	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("Someone modified the data in JTable!");
	}
	
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame("My Test Window");
		myFrame.pack();
		myFrame.setVisible(true);
	}

	class MyTableModel extends AbstractTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		ArrayList<Order> myData = new ArrayList<>();
		MyTableModel(){
			myData = Order.populateMyData();
//			myData.add(new Order(1, "IBM", 100, 135.5f));
//			myData.add(new Order(2, "AAPL", 300, 290.12f));
//			myData.add(new Order(3, "MOT", 2000, 8.32f));
//			myData.add(new Order(4, "ORCL", 500, 27.8f));
		}

		String[] orderColNames = {"Order ID", "Symbol", "Quantity", "Price"};

		public String getColumnName(int col){
			return orderColNames[col];
		}
		@Override
		public int getRowCount() {
			return myData.size();
		}

		@Override
		public int getColumnCount() {
			return 4;
		}
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			if(columnIndex == 2){
				myData.get(rowIndex).quantity = (Integer.valueOf(aValue.toString()));
			}
			TableModelEvent event = new TableModelEvent(this, rowIndex, rowIndex, columnIndex);
			fireTableChanged(event);
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex){
			case 0: //colmnIndex 1
				return myData.get(rowIndex).orderID;
			case 1:
				return myData.get(rowIndex).stockSymbol;
			case 2:
				return myData.get(rowIndex).quantity;
			case 3:
				return myData.get(rowIndex).price;
			default:
				return "";
			}
		}
		// making third column of our JTable editable:
		public boolean isCellEditable(int row, int col){
			if(col == 2){
				return true;
			} else {
				return false;
			}
		}
		//The data for JTable should be here
	}

	public static class Order{
		private int orderID;
		private String stockSymbol;
		private int quantity;
		private float price;

		public Order(int orderID, String stockSymbol, int quantity, float price) {
			this.orderID = orderID;
			this.stockSymbol = stockSymbol;
			this.quantity = quantity;
			this.price = price;
		}
		
		protected static ArrayList<Order> populateMyData(){
			ArrayList<Order> myData = new ArrayList<>();
			Statement stmt = null;
			ResultSet rs = null;
			
			Properties p = new Properties();
			p.put("user", "root");
			p.put("password", "");
			p.put("dbUrl", "jdbc:mysql://localhost:3306/ENTERPRISE");
			
			try(Connection myCon = DriverManager.getConnection((String)p.get("dbUrl"), p)){
				stmt = myCon.createStatement();
				cursorHoldabilitySupport(myCon);
				rs = stmt.executeQuery("select *from portfolio");
				ResultSetMetaData rsMeta = rs.getMetaData();
				int colCount = rsMeta.getColumnCount();
				for(int i = 1; i <= colCount; i++){
					System.out.print(rsMeta.getColumnName(i) + " ");
				}
				System.out.println();
				while(rs.next()){
					for(int i = 1; i <= colCount; i++){
						int orderId = rs.getInt(i); i++;
						String stockSymbol = rs.getString(i); i++;
						int quantity = rs.getInt(i); i++;
						float price = rs.getFloat(i);
						myData.add(new Order(orderId, stockSymbol, quantity, price));
					}
				}
			} catch (SQLException e){
				System.out.println("SQLError: " + e.getMessage());
			} catch (Exception e1){
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
			return myData;
		}
		public static void cursorHoldabilitySupport(Connection myCon) throws SQLException{
			DatabaseMetaData dbMetaData = myCon.getMetaData();
			System.out.println("ResultSet.HOLD_CURSORS_OVER_COMMIT = " +
			ResultSet.HOLD_CURSORS_OVER_COMMIT);
			System.out.println("ResultSet.CLOSE_CURSORS_AT_COMMIT = " +
			ResultSet.CLOSE_CURSORS_AT_COMMIT);
			System.out.println("Default cursor holdability: " +
			dbMetaData.getResultSetHoldability());
			System.out.println("Supports HOLD_CURSORS_OVER_COMMIT? " +
			dbMetaData.supportsResultSetHoldability(
					ResultSet.HOLD_CURSORS_OVER_COMMIT));
			System.out.println("Supports CLOSE_CURSORS_AT_COMMIT? " +
					dbMetaData.supportsResultSetHoldability(
							ResultSet.CLOSE_CURSORS_AT_COMMIT));
		}

	}

}
