package tasks.data;

import java.util.ArrayList;
import java.util.List;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo
public class DataTextDims extends JavaTask {

	@InputPortInfo(name = "In", dataType = Text.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void execute() {
		Text inText = in.getData(Text.class);
		List<String> outtext = new ArrayList<>(inText.getNumberOfElements());
		for(String v : inText.getValues())
			outtext.add(v.toUpperCase());
		out.putData(new Text(inText.getDimensions(), outtext));
	}
}
