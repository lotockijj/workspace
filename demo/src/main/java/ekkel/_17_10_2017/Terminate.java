package ekkel._17_10_2017;

import java.io.IOException;

class Terminate extends Thread{

	public static void main(String args[]) throws IOException, InterruptedException{
    	int i = 0;
    	while(System.in.available() == 0){
    		System.out.println("something" + i++);
    		Thread.currentThread();
			Thread.sleep(500);
    	}
    }
}