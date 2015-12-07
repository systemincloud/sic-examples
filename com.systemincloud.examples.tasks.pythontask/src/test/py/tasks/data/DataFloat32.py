from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Float32 import Float32

@PythonTaskInfo
class DataFloat32(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Float32)
        self.in2 = InputPort(name="in2", data_type=Float32)
        self.out = OutputPort(name="out", data_type=Float32)

    def execute(self, grp):
        in1Data = self.in1.get_data(Float32)
        in2Data = self.in2.get_data(Float32)
        self.out.put_data(Float32(in1Data.values[0] + in2Data.values[0]))
