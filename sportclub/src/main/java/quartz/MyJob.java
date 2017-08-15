package quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements org.quartz.Job{
	
	public MyJob(){
		
	}

	//This method should set number visits each month.
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Set number visits to each client of the gym. ");
	}
	
	

}
