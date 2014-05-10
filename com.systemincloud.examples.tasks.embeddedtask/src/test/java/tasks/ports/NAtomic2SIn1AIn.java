package tasks.ports;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo(atomic = false)
public class NAtomic2SIn1AIn extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Int32.class, asynchronus = true)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Int32.class)
	public InputPort in2;
	@InputPortInfo(name = "In3", dataType = Int32.class)
	public InputPort in3;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void executeAsync(InputPort asynchIn) {
		out.putData(new Text("From port " + asynchIn.getName() + ": " + asynchIn.getData(Int32.class).getValue()));
	}
}
