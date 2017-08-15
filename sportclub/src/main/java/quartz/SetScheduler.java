package quartz;

import static org.quartz.CronScheduleBuilder.monthlyOnDayAndHourAndMinute;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class SetScheduler {
	
	public static void main(String[] args) throws SchedulerException {
		JobDetail job = JobBuilder.newJob(MyJob.class)
				.withIdentity("dummyJobName", "group1").build();

		Trigger trigger = newTrigger()
			    .withIdentity("trigger3", "group1")
			    .startNow()
			    .withSchedule(monthlyOnDayAndHourAndMinute(1, 0, 0)) // fire on the 5th day of every month at 15:00
			    .build();

		
		Scheduler scheduler =  new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
	
}
