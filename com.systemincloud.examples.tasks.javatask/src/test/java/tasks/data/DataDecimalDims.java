package tasks.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Decimal;

@JavaTaskInfo
public class DataDecimalDims extends JavaTask {

	@InputPortInfo(name = "In", dataType = Decimal.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Decimal.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		Decimal inDecimal = in.getData(Decimal.class);
		List<BigDecimal> outdecimal = new ArrayList<>(inDecimal.getNumberOfElements());
		int i = 0;
		for(BigDecimal v : inDecimal.getValues()) {
			outdecimal.add(v.movePointRight(i));
			i++;
		}
		out.putData(new Decimal(inDecimal.getDimensions(), outdecimal));
	}

}
