package tasks.generator;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;

@JavaTaskInfo(generator = true)
public class GeneratorPauseResume extends JavaTask {

	@InputPortInfo(name = "In", dataType = Control.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Int32.class)
	public OutputPort out;

	private int i = 0;
	
	@Override
	public void generate() {
		sleep(500);
		out.putData(new Int32(i++));
	}

	@Override
	public void execute() {
		if(isPaused()) resume();
		else           pause();
	}

}
