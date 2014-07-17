package tasks.queue;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;

@JavaTaskInfo
public class AddOrMultiplication extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Int32.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Int32.class)
	public InputPort in2;
	@InputPortInfo(name = "Ctrl", dataType = Control.class, asynchronus = true)
	public InputPort ctrl;
	@OutputPortInfo(name = "Out", dataType = Int32.class)
	public OutputPort out;

	private boolean isAdd = false;
	
	@Override
	public void executeAsync(InputPort asynchIn) {
		this.isAdd = !isAdd;
	}

	@Override
	public void execute() {
		if(isAdd) out.putData(new Int32(in1.getData(Int32.class).getValue() + in2.getData(Int32.class).getValue()));
		else      out.putData(new Int32(in1.getData(Int32.class).getValue() * in2.getData(Int32.class).getValue()));
	}

}
