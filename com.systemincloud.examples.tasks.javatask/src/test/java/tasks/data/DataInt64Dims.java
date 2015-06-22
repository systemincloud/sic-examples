package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int64;

@JavaTaskInfo
public class DataInt64Dims extends JavaTask {

	@InputPortInfo(name = "In", dataType = Int64.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Int64.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		Int64 inInt64 = in.getData(Int64.class);
		long[] inint64 = inInt64.getValues();
		long[] outint = new long[inInt64.getNumberOfElements()];
		for(int i = 0; i < inInt64.getNumberOfElements(); i++)
			outint[i] = inint64[i]*2;
			
		out.putData(new Int64(inInt64.getDimensions(), outint));
	}

}
