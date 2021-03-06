package tasks.params;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.SicParameters;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.annotations.SicParameter;

@JavaTaskInfo
@SicParameters({
	@SicParameter(name=Expression.N)
}) public class Expression extends JavaTask {

	protected static final String N = "N";

	@InputPortInfo(name = "In", dataType = Int32.class)
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = Int32.class)
	public OutputPort out;

	private int n;

	@Override
	public void runnerStart() {
		this.n = (Integer) runExpression(getParameter(N));
	};

	@Override
	public void execute(int grp) {
		out.putData(new Int32(in.getData(Int32.class).getValue()*n));
	}

}
