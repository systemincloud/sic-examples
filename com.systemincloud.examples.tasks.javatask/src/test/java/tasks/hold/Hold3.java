package tasks.hold;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;

@JavaTaskInfo
public class Hold3 extends JavaTask {

	@InputPortInfo(name = "a", dataType = Int32.class)
	public InputPort aPort;
	@InputPortInfo(name = "x", dataType = Int32.class)
	public InputPort xPort;
	@InputPortInfo(name = "b", dataType = Int32.class)
	public InputPort bPort;
	@OutputPortInfo(name = "y", dataType = Int32.class)
	public OutputPort yPort;

	@Override
	public void execute(int grp) {
		int a = aPort.getData(Int32.class).getValue();
		int b = bPort.getData(Int32.class).getValue();
		int x = xPort.getData(Int32.class).getValue();
		yPort.putData(new Int32(a*x+b));
	}
}
