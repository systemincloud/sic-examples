from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Complex64 import Complex64

@PythonTaskInfo
class DataComplex64(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Complex64)
        self.in2 = InputPort(name="in2", data_type=Complex64)
        self.out = OutputPort(name="out", data_type=Complex64)

    def execute(self, grp):
        in1Data = self.in1.get_data(Complex64);
        in2Data = self.in2.get_data(Complex64);
        self.out.put_data(Complex64(in1Data.values[0] + in2Data.values[0]));
