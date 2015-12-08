package tasks.data;

import java.util.Random;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Raw;

@JavaTaskInfo(generator = true)
public class RawGenerator extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Raw.class)
	public OutputPort out;

	@Override
	public void generate() {
		byte[] ret = new byte[10];
		new Random().nextBytes(ret);
		out.putData(new Raw(ret));
	}
}
