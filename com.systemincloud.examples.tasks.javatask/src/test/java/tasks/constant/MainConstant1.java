package tasks.constant;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo(constant = true)
public class MainConstant1 extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;
	
	@Override
	public void execute() {
		out.putData(new Text("Hello World"));
	}

}
