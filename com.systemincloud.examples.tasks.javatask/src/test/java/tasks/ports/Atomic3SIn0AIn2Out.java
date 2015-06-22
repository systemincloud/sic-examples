package tasks.ports;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Float32;
import com.systemincloud.modeler.tasks.javatask.api.data.Float64;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo
public class Atomic3SIn0AIn2Out extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Float64.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Float32.class)
	public InputPort in2;
	@InputPortInfo(name = "In3", dataType = Int32.class)
	public InputPort in3;
	@OutputPortInfo(name = "Out1", dataType = Text.class)
	public OutputPort out1;
	@OutputPortInfo(name = "Out2", dataType = Int32.class)
	public OutputPort out2;

	@Override
	public void execute(int grp) {
		Float64 in1Text = in1.getData(Float64.class);
		Float32 in2Text = in2.getData(Float32.class);
		Int32 in3Text = in3.getData(Int32.class);
		double in1Double = in1Text.getValue();
		float  in2Float = in2Text.getValue();
		double sum = in1Double + (double) in2Float;
		out1.putData(new Text(in1Double + " + " + in2Float + " = " + sum));
		out2.putData(new Int32(in3Text.getValue()));
	}

}
