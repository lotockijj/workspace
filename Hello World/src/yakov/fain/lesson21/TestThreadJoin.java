package yakov.fain.lesson21;

import yakov.fain.lesson20.MarketNews3;
import yakov.fain.lesson20.Portfolio3;

public class TestThreadJoin {
	public static void main(String args[]){
		MarketNews3 mn = new MarketNews3("Market News");
		mn.start();
		Portfolio3 p = new Portfolio3("Portfolio data");
		p.start();
		try{
			mn.join();
			p.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println( "The main method of TestThreadJoin is finished");
	}
}