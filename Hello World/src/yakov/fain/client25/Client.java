package yakov.fain.client25;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import yakov.fain.Lesson25.StockServer;

public class Client {

	public static void main(String[] args){
		if (args.length == 0) {
			System.out.println("\n Sample usage: java client.Client AAPL");
			System.exit(0);
		}
		try{
			StockServer myServer = (StockServer)
					Naming.lookup("rmi://localhost:1099/QuoteService");
			String price = myServer.getQuote(args[0]);
			if(price != null){
				System.out.println("The price of " + args[0] +
						" is: $" + price);
			} else {
				System.out.println("Invalid Nasdaq symbol. " +
						"Please use one of these:" +
						myServer.getNasdagSymbols().toString());
			}
		} catch (MalformedURLException e){
			System.out.println(e);
		} catch (NotBoundException e1){
			System.out.println(e1);
		} catch (RemoteException e2){
			e2.printStackTrace();
		}
	}

}
