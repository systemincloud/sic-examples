package com.systemincloud.examples.tutorial10min;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.systemincloud.modeler.tasks.javatask.api.InputPort;
import com.systemincloud.modeler.tasks.javatask.api.JavaTask;
import com.systemincloud.modeler.tasks.javatask.api.OutputPort;
import com.systemincloud.modeler.tasks.javatask.api.annotations.InputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.JavaTaskInfo;
import com.systemincloud.modeler.tasks.javatask.api.annotations.OutputPortInfo;
import com.systemincloud.modeler.tasks.javatask.api.data.Int32;

@JavaTaskInfo
public class CountDensityFunction extends JavaTask {

	private static final int N = 1000;
	
	@InputPortInfo(name = "In", dataType = Int32.class)
	public InputPort in;
	@OutputPortInfo(name = "X", dataType = Int32.class)
	public OutputPort out_x;
	@OutputPortInfo(name = "Y", dataType = Int32.class)
	public OutputPort out_y;

	private List<Integer> queue = new LinkedList<>();
	
	private TreeMap<Integer, Integer> incidence = new TreeMap<>();
	
	@Override
	public void execute() {
		int i = in.getData(Int32.class).getValue();
		queue.add(i);
		Integer n_i = incidence.get(i);

		if(n_i == null) incidence.put(i, 1);
		else            incidence.put(i, n_i + 1);
		
		if(queue.size() > N) {
			Integer removed = queue.remove(0);
			Integer n_r = incidence.get(removed);
			if(n_r == 0) incidence.remove(n_r);
			else         incidence.put(removed, n_r - 1);
		}
		
		int[] x = new int[incidence.size()];
		int[] y = new int[incidence.size()];
		int j = 0;
		for(Entry<Integer, Integer> e : incidence.entrySet()) {
			x[j] = e.getKey();
			y[j] = e.getValue();
			j++;
		}
		out_x.putData(new Int32(Arrays.asList(1, x.length), x));
		out_y.putData(new Int32(Arrays.asList(1, y.length), y));
	}
}
