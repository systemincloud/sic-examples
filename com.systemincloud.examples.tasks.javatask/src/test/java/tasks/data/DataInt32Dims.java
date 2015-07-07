package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;

@JavaTaskInfo
public class DataInt32Dims extends JavaTask {

	@InputPortInfo(name = "In", dataType = Int32.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Int32.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		Int32 inInt32 = in.getData(Int32.class);
		int[] inint32 = inInt32.getValues();
		int[] outint = new int[inInt32.getNumberOfElements()];
		for(int i = 0; i < inInt32.getNumberOfElements(); i++)
			outint[i] = inint32[i] + 5;
			
		out.putData(new Int32(inInt32.getDimensions(), outint));
	}

}
