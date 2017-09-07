package designpatterns.twenty;

import designpatterns.ten.Logger;

public class FileLoggerAdapter extends LoggerIntr {
	private Logger fileLogger;
	
	public FileLoggerAdapter(Logger fileLogger) {
		this.fileLogger = fileLogger;
	}

	@Override
	public void logMessage(String msg) {
		fileLogger.log(msg);
	}

}
