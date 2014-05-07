package tasks.ports;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo(atomic = false)
public class MainNAtomic2SIn1Out extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Text.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Text.class)
	public InputPort in2;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void executeAsync(InputPort asynchIn) {
		out.putData(new Text("From port " + asynchIn.getName() + ": " + asynchIn.getData(Text.class).getValue()));
	}

}
