package yakov.fain.lesson21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallableThreads {
	
	public static void main(String[] args)
			throws InterruptedException, ExecutionException {
		//A placeholder for Future objects
		List<Future<Integer>> futures =
				new ArrayList<Future<Integer>>();
		// A placeholder for results
		List<Integer> results = new ArrayList<Integer>();
		final ExecutorService service =
				Executors.newFixedThreadPool(2); // pool of 2 threads
		try {
			futures.add(service.submit(new PortfolioCallable()));
			futures.add(service.submit(new MarketNewsCallable()));
			for (Future<Integer> future : futures) {
				results.add(future.get());
			}
		} finally {
			service.shutdown();
		}
		for (Integer res: results){
			System.out.println("\nGot the result: " + res);
		}
	}
}