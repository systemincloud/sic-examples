package tasks.data;

import java.util.Arrays;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Raw;

@JavaTaskInfo(generator = true)
public class DataRawDims1 extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Raw.class)
	public OutputPort out;

	@Override
	public void generate() {
		out.putData(new Raw(Arrays.asList(2), 
				            Arrays.asList("A".getBytes(), "B".getBytes())));
	}
}
