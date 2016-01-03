from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32

@PythonTaskInfo
class Stateful(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in")
        self.out = OutputPort(name="out", data_type=Int32)

    def __init__(self):
        self.i = 0

    def execute(self, grp):
        self.i += 1
        self.out.put_data(Int32(self.i))
