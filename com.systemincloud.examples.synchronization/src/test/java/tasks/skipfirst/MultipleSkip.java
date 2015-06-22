package tasks.skipfirst;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Bool;

@JavaTaskInfo
public class MultipleSkip extends JavaTask {

	@InputPortInfo(name = "In", dataType = Bool.class, queue=2)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Bool.class)
	public OutputPort out;

	boolean flag = false;
	boolean a;
	
	@Override
	public void execute(int grp) {
		if(flag) out.putData(new Bool(a && in.getData(Bool.class).getValue()));
		else a = in.getData(Bool.class).getValue();
		flag = !flag;
	}
}
