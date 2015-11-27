from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32

@PythonTaskInfo
class Constant2Add(PythonTask):

    def __init_ports__(self):
        self.in_1 = InputPort(name="In 1", data_type=Int32)
        self.in_2 = InputPort(name="In 2", data_type=Int32)
        self.out = OutputPort(name="Out", data_type=Int32)

    def execute(self, grp):
        self.in_1.get_data(Int32)
        suma = Int32(self.in_1.get_data(Int32).values[0] + self.in_2.get_data(Int32).values[0])
        self.out.put_data(suma)
