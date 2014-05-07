package tasks.extsrc;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo(externalSource = true)
public class MainExtSrc extends JavaTask {

	{
	    new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try { Thread.sleep(1000);
					} catch (InterruptedException e) { }
					externalData();
				}
			}
		}).start();
	}
	
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void executeExtSrc() {
		out.putData(new Text("Received data from outside world."));
	}

}
