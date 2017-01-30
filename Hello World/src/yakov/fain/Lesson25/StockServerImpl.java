package yakov.fain.Lesson25;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StockServerImpl extends UnicastRemoteObject implements StockServer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String price = null;
	private ArrayList<String> nasdagSymbols = new ArrayList<>();
	
	public StockServerImpl() throws RemoteException{
		super();
		// Define some hard-coded NASDAQ symbols
		nasdagSymbols.add("AAPL");
		nasdagSymbols.add("MSFT");
		nasdagSymbols.add("YHOO");
		nasdagSymbols.add("AMZN");
		nasdagSymbols.add("MOT");
	}

	@Override
	public String getQuote(String symbol) throws RemoteException {
		if(nasdagSymbols.indexOf(symbol.toUpperCase()) != -1) {
			// Generate a random price for valid symbols
			price = (new Double(Math.random()*100)).toString();
			}
			return price;
	}

	@Override
	public List<String> getNasdagSymbols() throws RemoteException {
		return nasdagSymbols;
	}
	
	

}
