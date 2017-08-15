package designpatterns.nine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {
	
	public synchronized String readLog(){
		String msg = null;
		try(FileReader fr = new FileReader("filename.txt");
				BufferedReader br = new BufferedReader(fr)){
			msg = br.readLine();
		} catch (IOException e){
			System.out.println(e);
		}
		return msg;
	}

}
