package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Data;
import com.systemincloud.modeler.tasks.javatask.api.data.Float32;
import com.systemincloud.modeler.tasks.javatask.api.data.Float64;

@JavaTaskInfo(atomic = false)
public class DataFloat32Float64Mux extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Float32.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Float64.class)
	public InputPort in2;
	@OutputPortInfo(name = "Out", dataType = { Float32.class, Float64.class })
	public OutputPort out;

	@Override
	public void executeAsync(InputPort asyncIn) {
		out.putData(asyncIn.getData(Data.class));
	}

}
