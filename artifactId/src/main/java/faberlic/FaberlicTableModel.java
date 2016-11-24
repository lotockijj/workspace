package main.java.faberlic;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import javafx.scene.control.TableColumn;

public class FaberlicTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	public  static final int OBJECT_COL = -1;
	private static final int ID_COL = 0;
	private static final int NAME_COL = 1;
	private static final int ARTICLE_COL = 2;
	private static final int AMOUNT_COL = 3;
	private static final int DATE_PRODUCTION_COL = 4;
	private static final int EXPIRATION_DATE_COL = 5;
	private static final int END_DATE_COL = 6;
	
	String[] columnNames = {"id", "name", "article", "amount", "production",
			"expiration", "end"};
	
	private List<Faberlic> faberlicGoods;
	
	 TableColumn column = null;

	public FaberlicTableModel(List<Faberlic> theFaberlicGoods) {
		faberlicGoods = theFaberlicGoods;
	}
	
	@Override
	public int getRowCount() {
		return faberlicGoods.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Faberlic tempFaberlic = faberlicGoods.get(row);
		switch(col){
		case ID_COL :
			return tempFaberlic.getId();
		case NAME_COL :
			return tempFaberlic.getName();
		case ARTICLE_COL :
			return tempFaberlic.getArticle();
		case AMOUNT_COL : 
			return tempFaberlic.getAmount();
		case DATE_PRODUCTION_COL :
			return tempFaberlic.getDate_production();
		case EXPIRATION_DATE_COL : 
			return tempFaberlic.getExpiration_date();
		case END_DATE_COL :
			return tempFaberlic.getEnd_date();
		case OBJECT_COL :
			return tempFaberlic;
		default :
			return tempFaberlic.getId();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}
