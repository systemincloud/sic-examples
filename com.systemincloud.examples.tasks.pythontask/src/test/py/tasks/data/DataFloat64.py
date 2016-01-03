from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Float64 import Float64

@PythonTaskInfo
class DataFloat64(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Float64)
        self.in2 = InputPort(name="in2", data_type=Float64)
        self.out = OutputPort(name="out", data_type=Float64)

    def execute(self, grp):
        in1Data = self.in1.get_data(Float64)
        in2Data = self.in2.get_data(Float64)
        self.out.put_data(Float64(in1Data.value + in2Data.value))
