package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Bool;

@JavaTaskInfo
public class DataBool extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Bool.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Bool.class)
	public InputPort in2;
	@OutputPortInfo(name = "Out", dataType = Bool.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		Bool in1Bool = in1.getData(Bool.class);
		Bool in2Bool = in2.getData(Bool.class);
		out.putData(new Bool(in1Bool.getValues()[0] && in2Bool.getValues()[0]));
	}
}
