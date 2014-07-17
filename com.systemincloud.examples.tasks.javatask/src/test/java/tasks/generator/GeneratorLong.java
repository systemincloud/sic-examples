package tasks.generator;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;

@JavaTaskInfo(generator = true)
public class GeneratorLong extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Control.class)
	public OutputPort out;

	@Override
	public void generate() {
		sleep(3000);
		try { Thread.sleep(2000); } catch (InterruptedException e) { }
		out.putData(new Control());
	}
}
