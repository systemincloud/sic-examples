package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Complex32;

@JavaTaskInfo
public class DataComplex32 extends JavaTask {

	@InputPortInfo(name = "In1", dataType = Complex32.class)
	public InputPort in1;
	@InputPortInfo(name = "In2", dataType = Complex32.class)
	public InputPort in2;
	
	@OutputPortInfo(name = "Out", dataType = Complex32.class)
	public OutputPort out;
	
	@Override
	public void execute() {
		Complex32 data1 = in1.getData(Complex32.class);
		Complex32 data2 = in2.getData(Complex32.class);
		out.putData(new Complex32(data1.getRealValue() + data2.getRealValue(), 
				                  data1.getImagValue() + data2.getImagValue()));
	}

}
