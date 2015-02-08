package tasks.sequence;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;

@JavaTaskInfo
public class Sequence extends JavaTask {

	@InputPortInfo(name = "In", dataType = Int32.class)
	public InputPort in;
	@OutputPortInfo(name = "Value", dataType = Int32.class)
	public OutputPort value;
	@OutputPortInfo(name = "Power", dataType = Int32.class)
	public OutputPort power;

	boolean flag = true;

	@Override
	public void execute() {
		int inValue = in.getData(Int32.class).getValue();
		if(flag) value.putData(new Int32(inValue));
		else     power.putData(new Int32(inValue*inValue));
		flag = !flag;
	}

}
