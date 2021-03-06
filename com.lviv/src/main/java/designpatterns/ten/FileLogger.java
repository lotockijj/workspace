package designpatterns.ten;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public enum FileLogger implements Logger {
	INSTANSE;

	public void log(String msg) {
		File file = new File("logger.txt");
		try {
			if(file.createNewFile()){
				System.out.println("File already exists.");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Files.write(Paths.get("logger.txt"), msg.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
