from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Complex32 import Complex32

@PythonTaskInfo
class DataComplex32(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Complex32)
        self.in2 = InputPort(name="in2", data_type=Complex32)
        self.out = OutputPort(name="out", data_type=Complex32)

    def execute(self, grp):
        in1Data = self.in1.get_data(Complex32)
        in2Data = self.in2.get_data(Complex32)
        self.out.put_data(Complex32(in1Data.value + in2Data.value))
