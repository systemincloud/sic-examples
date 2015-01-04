package tasks.constants;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Bool;
import com.systemincloud.modeler.tasks.javatask.api.data.Data;

@JavaTaskInfo(atomic=false)
public class TwoConstants extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Bool.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Bool.class)
	public InputPort in2;
	@OutputPortInfo(name = "Out", dataType = Bool.class)
	public OutputPort out;

	@Override
	public void executeAsync(InputPort asynchIn) {
		out.putData(asynchIn.getData(Data.class));
	}

}
