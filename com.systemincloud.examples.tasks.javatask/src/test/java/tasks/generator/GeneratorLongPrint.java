package tasks.generator;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo(atomic = false)
public class GeneratorLongPrint extends JavaTask {

	@InputPortInfo(name = "Time", dataType = Control.class)
	public InputPort time;
	@InputPortInfo(name = "In", dataType = Control.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void executeAsync(InputPort asynchIn) {
		if(asynchIn == time) out.putData(new Text("+"));
		if(asynchIn == in)   out.putData(new Text("-----+"));
	}

}
