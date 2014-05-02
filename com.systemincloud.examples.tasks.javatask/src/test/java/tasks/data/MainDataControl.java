package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;

@JavaTaskInfo
public class MainDataControl extends JavaTask {

	@InputPortInfo(name = "In", dataType = Control.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Control.class)
	public OutputPort out;

	@Override
	public void execute() {
		in.getData(Control.class);
		out.putData(new Control());
	}
}
