package tasks.generator;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;

@JavaTaskInfo(atomic = false, generator = true)
public class GeneratorNAtomicWith2SIn extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Int32.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Int32.class)
	public InputPort in2;
	@OutputPortInfo(name = "Out", dataType = Int32.class)
	public OutputPort out;

	private int left  = -1;
	private int right = -2;
	
	@Override
	public void executeAsync(InputPort asynchIn) {
		if("In1".equals(asynchIn.getName())) left  = asynchIn.getData(Int32.class).getValue();
		if("In2".equals(asynchIn.getName())) right = asynchIn.getData(Int32.class).getValue();
	}

	@Override
	public void generate() {
		if(left == right) out.putData(new Int32(left));
		sleep(200);
	}

}
