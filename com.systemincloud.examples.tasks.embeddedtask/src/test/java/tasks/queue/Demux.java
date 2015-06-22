package tasks.queue;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;

@JavaTaskInfo
public class Demux extends JavaTask {

	@InputPortInfo(name = "In", dataType = Int32.class)
	public InputPort in;
	@InputPortInfo(name = "Ctrl", dataType = Control.class, asynchronous = true)
	public InputPort ctrl;
	@OutputPortInfo(name = "Out1", dataType = Int32.class)
	public OutputPort out1;
	@OutputPortInfo(name = "Out2", dataType = Int32.class)
	public OutputPort out2;

	private boolean side = false;
	
	@Override
	public void executeAsync(InputPort asynchIn) {
		this.side = !side;
	}

	@Override
	public void execute(int grp) {
		if(side) out1.putData(in.getData(Int32.class));
		else     out2.putData(in.getData(Int32.class));
	}

}
