package yakov.fain.Lesson25;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class StartServer {

	public static void main(String[] args) {
		try{
			LocateRegistry.createRegistry(1099);
			StockServerImpl ssi = new StockServerImpl();
			Naming.rebind("rmi://localhost:1099/QuoteService", ssi);
		} catch (MalformedURLException e){
			System.out.println(e.getMessage());
		} catch (RemoteException e1){
			e1.printStackTrace();
		}
	}

}
