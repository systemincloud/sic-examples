package tasks.queue;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.SicParameters;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.annotations.SicParameter;

@JavaTaskInfo(generator = true)
@SicParameters({@SicParameter(name=N.INTERVAL)}) public class N extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Int32.class)
	public OutputPort out;

	protected static final String INTERVAL = "INTERVAL";
	
	private int i = 0;
	
	@Override
	public void runnerStart() {
		sleep(Integer.parseInt(getParameter(INTERVAL)));
	};
	
	@Override
	public void generate() {
		out.putData(new Int32(i++));
	}

}
