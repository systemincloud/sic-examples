package tasks.ports;


import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;
@JavaTaskInfo
public class MainAtomic2SIn1AIn1Out extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Text.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Text.class)
	public InputPort in2;
	@InputPortInfo(name = "In3", dataType = Text.class, asynchronus = true)
	public InputPort in3;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void executeAsync(InputPort asynchIn) {
		Text in3Text = in3.getData(Text.class);
		out.putData(new Text("From port In3: " + in3Text.getValue()));
	}

	@Override
	public void execute() {
		Text in1Text = in1.getData(Text.class);
		Text in2Text = in2.getData(Text.class);
		out.putData(new Text(in1Text.getValue() + " " + in2Text.getValue()));
	}

}
