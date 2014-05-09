package tasks.datacast;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int64;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo
public class DataInt64Casted extends JavaTask {

	@InputPortInfo(name = "In", dataType = Int64.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void execute() {
		Int64 inInt64 = in.getData(Int64.class);
		out.putData(new Text("Casted " + inInt64.getValue()));
	}

}
