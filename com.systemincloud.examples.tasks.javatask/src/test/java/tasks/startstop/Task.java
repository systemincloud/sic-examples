package tasks.startstop;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;

@JavaTaskInfo
public class Task extends JavaTask {

	@InputPortInfo(name = "In", dataType = Control.class)
	public InputPort in;

	@Override public void runnerStart() {
		System.out.println("Task started");
	}
	
	@Override
	public void execute(int grp) {
		System.out.println("Task run");
	}

	@Override public void runnerStop() {
		System.out.println("Task stopped");
	}
}
