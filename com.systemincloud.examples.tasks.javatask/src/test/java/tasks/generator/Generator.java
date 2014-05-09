package tasks.generator;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo(generator = true)
public class Generator extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void generate() {
		out.putData(new Text("Hello World"));
		sleep(3000);
	}
}
