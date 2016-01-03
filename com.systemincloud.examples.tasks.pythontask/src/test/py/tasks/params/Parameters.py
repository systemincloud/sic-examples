from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.SicParameter import SicParameter
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32

@PythonTaskInfo
@SicParameter(name="M")
@SicParameter(name="N", default_value="5")
class Parameters(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in", data_type=Int32)
        self.out = OutputPort(name="out", data_type=Int32)

    def runner_start(self):
        self.n = int(self.get_parameter('N'))
        self.m = int(self.get_parameter('M'))

    def execute(self, grp):
        self.out.put_data(Int32(self.in_.get_data(Int32).values[0]*self.n + self.m))

