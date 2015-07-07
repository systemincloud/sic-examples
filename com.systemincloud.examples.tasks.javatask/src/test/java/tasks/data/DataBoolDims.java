package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Bool;

@JavaTaskInfo
public class DataBoolDims extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Bool.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Bool.class)
	public InputPort in2;
	@OutputPortInfo(name = "Out", dataType = Bool.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		Bool in1Bool = in1.getData(Bool.class);
		Bool in2Bool = in2.getData(Bool.class);
		if(in1Bool.equalDimensions(in2Bool)) {
			boolean[] in1bool = in1Bool.getValues();
			boolean[] in2bool = in2Bool.getValues();
			boolean[] outbool = new boolean[in1Bool.getNumberOfElements()];
			for(int i = 0; i < in1Bool.getNumberOfElements(); i++)
				outbool[i] = in1bool[i] && in2bool[i];
			out.putData(new Bool(in1Bool.getDimensions(), outbool));
		}
	}

}
