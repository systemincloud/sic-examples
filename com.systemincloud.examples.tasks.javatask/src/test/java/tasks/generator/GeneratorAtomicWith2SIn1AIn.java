package tasks.generator;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.data.Control;

@JavaTaskInfo(generator = true)
public class GeneratorAtomicWith2SIn1AIn extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Int32.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Int32.class)
	public InputPort in2;
	@InputPortInfo(name = "In3", dataType = Control.class, asynchronus = true)
	public InputPort in3;
	@OutputPortInfo(name = "Out", dataType = Int32.class)
	public OutputPort out;

	private boolean on = false;
	
	@Override
	public void executeAsync(InputPort asynchIn) {
		this.on = !on;
	}

	@Override
	public void generate() {
		if(on) out.putData(new Int32(637343730));
		sleep(500);
	}

	@Override
	public void execute() {
		out.putData(new Int32(in1.getData(Int32.class).getValue() + in2.getData(Int32.class).getValue()));
	}

}
