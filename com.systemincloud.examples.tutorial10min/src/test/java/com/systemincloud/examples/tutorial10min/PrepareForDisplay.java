package com.systemincloud.examples.tutorial10min;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;
import com.systemincloud.modeler.tasks.javatask.api.data.Text;

@JavaTaskInfo
public class PrepareForDisplay extends JavaTask {

	@InputPortInfo(name = "X", dataType = Int32.class)
	public InputPort x;
	@InputPortInfo(name = "Y", dataType = Int32.class)
	public InputPort y;
	@OutputPortInfo(name = "Out", dataType = Text.class)
	public OutputPort out;

	@Override
	public void execute(int grp) {
		int[] xValues = x.getData(Int32.class).getValues();
		int[] yValues = y.getData(Int32.class).getValues();
		
		StringBuilder outText = new StringBuilder();
		outText.append("\0");
		
		for(int i = 0; i < xValues.length; i++) {
			outText.append(xValues[i]).append(":");
			int j = yValues[i];
			while(j-- > 0) outText.append("*");
			outText.append("\n");
		}
		out.putData(new Text(outText.toString()));
	}

}
