from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int64 import Int64

@PythonTaskInfo
class DataInt64(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Int64)
        self.in2 = InputPort(name="in2", data_type=Int64)
        self.out = OutputPort(name="out", data_type=Int64)

    def execute(self, grp):
        in1Data = self.in1.get_data(Int64)
        in2Data = self.in2.get_data(Int64)
        self.out.put_data(Int64(in1Data.values[0] + in2Data.values[0]))