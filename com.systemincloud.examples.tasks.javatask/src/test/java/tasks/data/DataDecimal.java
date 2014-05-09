package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Decimal;

@JavaTaskInfo
public class DataDecimal extends JavaTask {

	@InputPortInfo(name = "In", dataType = Decimal.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Decimal.class)
	public OutputPort out;

	@Override
	public void execute() {
		Decimal inDecimal = in.getData(Decimal.class);
		out.putData(new Decimal(inDecimal.getValue().movePointRight(1)));
	}

}
