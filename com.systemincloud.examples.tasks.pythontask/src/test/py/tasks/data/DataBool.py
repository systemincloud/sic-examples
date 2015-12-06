from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Bool import Bool

@PythonTaskInfo
class DataBool(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Bool)
        self.in2 = InputPort(name="in2", data_type=Bool)
        self.out = OutputPort(name="out", data_type=Bool)

    def execute(self, grp):
        in1Bool = self.in1.get_data(Bool)
        in2Bool = self.in2.get_data(Bool)
        self.out.put_data(Bool(in1Bool.values[0] and in2Bool.values[0]))

