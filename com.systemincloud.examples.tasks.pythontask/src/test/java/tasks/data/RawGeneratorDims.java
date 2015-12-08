package tasks.data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Raw;

@JavaTaskInfo(generator = true)
public class RawGeneratorDims extends JavaTask {

	@OutputPortInfo(name = "Out", dataType = Raw.class)
	public OutputPort out;

	@Override
	public void generate() {
		byte[] ret1 = new byte[10];
		byte[] ret2 = new byte[10];
		new Random().nextBytes(ret1);
		new Random().nextBytes(ret2);
		List<byte[]> ret = new LinkedList<>();
		ret.add(ret1);
		ret.add(ret2);
		out.putData(new Raw(Arrays.asList(new Integer[] {1, 2}), ret));
	}
}
