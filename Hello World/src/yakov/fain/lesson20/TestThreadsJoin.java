package yakov.fain.lesson20;

public class TestThreadsJoin {

	public static void main(String args[]){

		MarketNews3 mn = new MarketNews3("Market News");
		mn.start();
		Portfolio3 p = new Portfolio3("Portfolio data");
		p.start();

		try{
			mn.join();
			p.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}

		System.out.println( "The main method of TestThreads3 is finished");
	}

}
