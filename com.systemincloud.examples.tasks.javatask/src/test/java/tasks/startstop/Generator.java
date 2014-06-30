package tasks.startstop;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;

@JavaTaskInfo(generator=true)
public class Generator extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Control.class)
	public OutputPort out;
	
	private int i = 4;
	
	@Override public void runnerStart() {
		System.out.println("Generator started");
	}
	
	@Override
	public void generate() {
		if(i-- == 0) super.end();
		out.putData(new Control());
		sleep(500);
	}
	
	@Override public void runnerStop() {
		System.out.println("Generator stopped");
	}
}
