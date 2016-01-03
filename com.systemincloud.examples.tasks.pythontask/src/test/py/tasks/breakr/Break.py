from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.data.Int32 import Int32

@PythonTaskInfo
class Break(PythonTask):

    def __init_ports__(self):
        self.in_1 = InputPort(name="In", data_type=Int32)

    def execute(self, grp):
        i = self.in_1.get_data(Int32).values[0]
        if i == 3:
            self.exit_runner()
