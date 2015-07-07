package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Float32;

@JavaTaskInfo
public class DataFloat32Dims extends JavaTask {

	@InputPortInfo(name = "In", dataType = Float32.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Float32.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		Float32 inFloat32 = in.getData(Float32.class);
		float[] infloat32 = inFloat32.getValues();
		float[] outfloat = new float[inFloat32.getNumberOfElements()];
		for(int i = 0; i < inFloat32.getNumberOfElements(); i++)
			outfloat[i] = infloat32[i]*2;
			
		out.putData(new Float32(inFloat32.getDimensions(), outfloat));
	}

}
