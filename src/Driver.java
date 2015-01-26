
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.sunnee.quartz.SoundJob;
 public class Driver {

	public static void main(String ...args) throws Exception {

		
		JobKey soundJobKey = new JobKey("soundJob", "group1");
		JobDetail jobSound = JobBuilder.newJob(SoundJob.class).withIdentity(soundJobKey).build();
		
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("dummyTriggerName1", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("* * 9-20 * * ?"))
				.build();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		
		scheduler.start();
		scheduler.scheduleJob(jobSound, trigger);
	}
}
