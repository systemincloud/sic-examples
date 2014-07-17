package tasks.data;

import java.util.Arrays;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Raw;

@JavaTaskInfo(generator = true)
public class DataRawDims2 extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Raw.class)
	public OutputPort out;

	@Override
	public void generate() {
		byte[] bytes1 = new byte[] { (byte) 61, (byte) 62, (byte) 63, (byte) 64 };
		byte[] bytes2 = new byte[] { (byte) 65, (byte) 66, (byte) 67, (byte) 68 };
		out.putData(new Raw(Arrays.asList(2), Arrays.asList(bytes1, bytes2)));
	}
}
