package designpatterns.nine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogReader {
	private static final Object lock = new Object();

	public String readLog(){
		synchronized(lock){
			String msg = null;
			try(FileReader fr = new FileReader("filename.txt");
					BufferedReader br = new BufferedReader(fr)){
				msg = br.readLine();
				System.out.println(msg);
			} catch (IOException e){
				System.out.println(e);
			}
			return msg;
		}
	}
	
	public static void main(String[] args) {
		LogReader logReader1 = new LogReader();
		LogReader logReader2 = new LogReader();
		LogReader logReader3 = new LogReader();
		Runnable task1 = () -> {
			logReader1.readLog();
		};
		Runnable task2 = () -> {
			logReader2.readLog();
		};
		Runnable task3 = () -> {
			logReader3.readLog();
		};
		List<Runnable> listTasks = new ArrayList<>();
		listTasks.add(task1);
		listTasks.add(task2);
		listTasks.add(task3);
		for(int r = 0; r < listTasks.size(); r++){
			Thread t = new Thread(listTasks.get(r));
			t.getName();
			t.start();
			System.out.println("Name of current thread is: " + t.getName().toUpperCase());
		}
//		Thread t1 = new Thread(task1);
//		System.out.println(t1.getName());
//		t1.start();
//		t1 = new Thread(task2);
//		System.out.println(t1.getName());
//		t1.start();
//		t1 = new Thread(task3);
//		System.out.println(t1.getName());
//		t1.start();
	}

}
