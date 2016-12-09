package parse.faberlic1;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class JTableFaberlic15_2016 extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	private static final int OBJECT_COL = -1;
	private static final int DISCOUNT_COL = 0;
	private static final int PAGE_COL = 1;
	private static final int ARTICLE_COL = 2;
	private static final int NAME_COL = 3;
	private static final int PRICE_CATALOG_COL = 4;
	private static final int THE_SAME_COL = 5;
	private static final int ALLOWANCE_COL = 6;
	private static final int PRICE_STORE_COL = 7;
	private static final int BALL_CONSULTANT_COL = 8;
	private static final int PRICE_BUYER_COL = 9;
	private static final int BALL_BUYER_COL = 10;

	String[] columnNames = {"АКЦИЯ", "CTP", "AРТИКУЛ", "НАИМЕНОВАНИЕ", 
			"ЦЕНА КАТАЛОГА В ГРН.", "ТЕЖ", "СКИДКА", "ЦЕНА СКДАДА КОНС.", 
			"БАЛЛ КОНС", "ЦЕНА СКЛАДА ПОКУПАТ.", "БАЛЛ ПОКУПАТ."};

	private List<Goods> goods;

	public JTableFaberlic15_2016(List<Goods> theGoods) {
		this.goods = theGoods;
	}

	@Override
	public int getRowCount() {
		return 300;
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
	public Object getValueAt(int rowIndex, int columnIndex) {

		Goods tempGoods = goods.get(rowIndex);

		switch(columnIndex){
		case DISCOUNT_COL:
			return tempGoods.getDiscount();
		case PAGE_COL:
			return tempGoods.getPage();
		case ARTICLE_COL:
			return tempGoods.getArticle();
		case NAME_COL:
			return tempGoods.getName();
		case PRICE_CATALOG_COL:
			return tempGoods.getPriceCatalog();
		case THE_SAME_COL:
			return tempGoods.getTheSame();
		case ALLOWANCE_COL:
			return tempGoods.getAllowance();
		case PRICE_STORE_COL:
			return tempGoods.getPriceStore();
		case BALL_CONSULTANT_COL:
			return tempGoods.getBallConsultant();
		case PRICE_BUYER_COL:
			return tempGoods.getPriceBuyer();
		case BALL_BUYER_COL:
			return tempGoods.getBallBuyer();
			default : return tempGoods.getDiscount();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public static void main(String[] args) {

	}


}
