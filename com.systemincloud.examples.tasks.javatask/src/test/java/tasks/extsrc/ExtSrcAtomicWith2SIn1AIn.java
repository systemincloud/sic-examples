package tasks.extsrc;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo(externalSource = true)
public class ExtSrcAtomicWith2SIn1AIn extends JavaTask {

	{
	    new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try { Thread.sleep(2000);
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
	@InputPortInfo(name = "In3", dataType = Int32.class, asynchronus = true)
	public InputPort in3;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void executeExtSrc() {
		out.putData(new Text("External data"));
	}
	
	@Override
	public void executeAsync(InputPort asynchIn) {
//		System.out.println("executeAsync");
//		System.out.println(asynchIn.getName());
//		System.out.println(asynchIn.getData(Int32.class));
		out.putData(new Text("From " + asynchIn.getName() + ": " + asynchIn.getData(Int32.class).getValue()));
	}

	@Override
	public void execute() {
//		System.out.println("execute");
//		System.out.println(in2.getName());
//		System.out.println(in2.getData(Int32.class));
		out.putData(new Text("From In2: " + in2.getData(Int32.class).getValue()));
	}

}
