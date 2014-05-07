package tasks.extsrc;

import java.util.LinkedList;
import java.util.List;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int64;

@JavaTaskInfo(externalSource = true)
public class MainExtSrcMultiple extends JavaTask {

	private List<Integer> values = new LinkedList<>();

	{
	    new Thread(new Runnable() {
	    	private int i = 0;
			@Override public void run() {
				while(true) {
					try { Thread.sleep(1000);
					} catch (InterruptedException e) { }
					values.add(i++);
					values.add(i++);
					externalData(values.size());
				}
			}
		}).start();
	}
	
	@OutputPortInfo(name = "Out", dataType = Int64.class)
	public OutputPort out;

	@Override
	public void executeExtSrc() {
		if(values.size() > 0)
			out.putData(new Int64(values.remove(0)));
	}
}
