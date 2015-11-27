from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32

@PythonTaskInfo(constant=True)
class Constant2(PythonTask):

    def __init_ports__(self):
        self.out = OutputPort(name="Out", data_type=Int32)

    def execute(self, grp):
        self.out.put_data(Int32(5))
