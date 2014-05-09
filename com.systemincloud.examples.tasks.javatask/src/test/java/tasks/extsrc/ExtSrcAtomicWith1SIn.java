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
public class ExtSrcAtomicWith1SIn extends JavaTask {

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
	
	@InputPortInfo(name = "In", dataType = Int32.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void executeExtSrc() {
		out.putData(new Text("External data"));
	}

	@Override
	public void execute() {
		out.putData(new Text("From In: " + in.getData(Int32.class).getValue()));
	}

}
