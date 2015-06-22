package tasks.ports;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;
import com.systemincloud.modeler.tasks.javatask.api.data.Bool;

@JavaTaskInfo
public class Atomic2SIn0AIn1Out extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Text.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Text.class)
	public InputPort in2;
	@OutputPortInfo(name = "Out", dataType = Bool.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		Text in1Text = in1.getData(Text.class);
		Text in2Text = in2.getData(Text.class);
		out.putData(new Text(in1Text.getValue() + " " + in2Text.getValue()));
	}

}
