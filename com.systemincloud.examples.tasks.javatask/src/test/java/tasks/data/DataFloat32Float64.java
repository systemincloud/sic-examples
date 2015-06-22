package tasks.data;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Data;
import com.systemincloud.modeler.tasks.javatask.api.data.Float32;
import com.systemincloud.modeler.tasks.javatask.api.data.Float64;

@JavaTaskInfo
public class DataFloat32Float64 extends JavaTask {

	@InputPortInfo(name = "In", dataType = { Float32.class, Float64.class })
	public InputPort in;
	@OutputPortInfo(name = "Out", dataType = { Float32.class, Float64.class })
	public OutputPort out;

	private interface Strategy {
		void execute();
	}
	
	private class Float32Strategy implements Strategy {

		private Float32 data;
		
		public Float32Strategy(Float32 data) { this.data = data; }

		@Override
		public void execute() {
			out.putData(new Float32(data.getValue() * 2));
		}
	}
	
	private class Float64Strategy implements Strategy {

		private Float64 data;
		
		public Float64Strategy(Float64 data) { this.data = data; }

		@Override
		public void execute() {
			out.putData(new Float64(data.getValue() * 2));
		}
	}
	
	@Override
	public void execute(int grp) {
		Data data = in.getData(Data.class);
		     if(data instanceof Float32) new Float32Strategy((Float32) data).execute();
		else if(data instanceof Float64) new Float64Strategy((Float64) data).execute();
	}

}
