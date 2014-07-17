package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Raw;

@JavaTaskInfo(generator = true)
public class DataRaw extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Raw.class)
	public OutputPort out;
	
	@Override
	public void generate() {
		byte[] bytes = "String".getBytes();
		out.putData(new Raw(bytes));
	}
}
