package tasks.extsrc;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo(atomic = false, externalSource = true)
public class MainExtSrcNAtomicWith2SIn extends JavaTask {

	{
	    new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try { Thread.sleep(3000);
					} catch (InterruptedException e) { }
					externalData();
				}
			}
		}).start();
	}
	
	@InputPortInfo(name = "In1", dataType = Int32.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Int32.class)
	public InputPort in2;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void executeAsync(InputPort asynchIn) {
		out.putData(new Text("Port " + asynchIn.getName() + ": " + asynchIn.getData(Int32.class).getValue()));
	}

	@Override
	public void executeExtSrc() {
		out.putData(new Text("Received data from outside world."));
	}

}
