package tasks.ports;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.data.Bool;

@JavaTaskInfo
public class Atomic2Sin1AIn extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Control.class, asynchronus = true)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Int32.class)
	public InputPort in2;
	@InputPortInfo(name = "In3", dataType = Int32.class)
	public InputPort in3;
	@OutputPortInfo(name = "Out", dataType = Bool.class)
	public OutputPort out;

	private boolean lock = false;
	
	@Override
	public void executeAsync(InputPort asynchIn) {
		lock = !lock;
	}

	@Override
	public void execute() {
		if(!lock)
			out.putData(new Int32(in2.getData(Int32.class).getValue() + in3.getData(Int32.class).getValue()));
	}

}
