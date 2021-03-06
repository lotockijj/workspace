package designpatterns.ten;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoggerFactory {
	
	public Logger getLogger(){
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("Logger.properties"));
			String fileLoggingValue = p.getProperty("fileLoggingValue");
			if(fileLoggingValue.equalsIgnoreCase("db")){
				return DBLogger.getInstance();
			}
			if(fileLoggingValue.equalsIgnoreCase("file")){
				return FileLogger.INSTANSE;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ConsoleLogger.getInstance();
	}
	
	public static void main(String[] args) {
		LoggerFactory loggerFactory = new LoggerFactory();
		Logger logger = loggerFactory.getLogger();
		logger.log("Hello Roman :)");
	}
}
