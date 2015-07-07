package tasks.hold;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo
public class Default extends JavaTask {

	@InputPortInfo(name = "In 1", dataType = Text.class, hold = true)
	public InputPort in1;
	@InputPortInfo(name = "In 2", dataType = Text.class)
	public InputPort in2;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		out.putData(new Text(in1.getData(Text.class).getValue() + in2.getData(Text.class).getValue()));
	}

}
