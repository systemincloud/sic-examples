package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Float64;

@JavaTaskInfo
public class DataFloat64 extends JavaTask {

	@InputPortInfo(name = "In", dataType = Float64.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Float64.class)
	public OutputPort out;

	@Override
	public void execute() {
		Float64 inFloat64 = in.getData(Float64.class);
		out.putData(new Float64(inFloat64.getValue()/2));
	}

}
