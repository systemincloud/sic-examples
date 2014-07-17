package tasks.queue;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;

@JavaTaskInfo(generator = true)
public class Generator extends JavaTask {

	@OutputPortInfo(name = "Out1", dataType = Int32.class)
	public OutputPort out1;
	@OutputPortInfo(name = "Out2", dataType = Int32.class)
	public OutputPort out2;

	private int i = 1;
	private boolean side = true;
	
	
	@Override
	public void generate() {
		if(side) out2.putData(new Int32(i));
		else     out1.putData(new Int32(i));
		if((i++)%5 == 0) this.side = ! this.side;
	}

}
