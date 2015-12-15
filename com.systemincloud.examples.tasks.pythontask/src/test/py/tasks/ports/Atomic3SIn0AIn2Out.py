from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32
from sicpythontask.data.Float32 import Float32
from sicpythontask.data.Float64 import Float64
from sicpythontask.data.Text import Text

@PythonTaskInfo
class Atomic3SIn0AIn2Out(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Float64)
        self.in2 = InputPort(name="in2", data_type=Float32)
        self.in3 = InputPort(name="in3", data_type=Int32)
        self.out1 = OutputPort(name="out1", data_type=Int32)
        self.out2 = OutputPort(name="out2", data_type=Text)

    def execute(self, grp):
        in1Text = self.in1.get_data(Float64)
        in2Text = self.in2.get_data(Float32)
        in3Text = self.in3.get_data(Int32)
        in1Double = in1Text.value
        in2Float = in2Text.value
        sum_ = in1Double + in2Float
        self.out2.put_data(Text(str(in1Double) + " + " + str(in2Float) + " = " + str(sum_)))
        self.out1.put_data(Int32(in3Text.value));

