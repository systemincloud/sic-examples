package tasks.breakr;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;

@JavaTaskInfo
public class Break extends JavaTask {

	@InputPortInfo(name = "In", dataType = Int32.class)
	public InputPort in;

	@Override
	public void execute() {
		int i = in.getData(Int32.class).getValue();
		if(i == 3) super.exitRunner();
	}
}
