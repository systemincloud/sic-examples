package tasks.ticks;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Bool;

@JavaTaskInfo
public class MutlipleTicks extends JavaTask {

	@InputPortInfo(name = "In", dataType = Bool.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Bool.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		boolean inValue = in.getData(Bool.class).getValue();
		out.putData(new Bool(inValue));
		out.putData(new Bool(!inValue));
	}

}
