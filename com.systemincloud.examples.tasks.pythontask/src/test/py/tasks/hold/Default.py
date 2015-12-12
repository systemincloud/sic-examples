from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Text import Text

@PythonTaskInfo
class Default(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Text)
        self.in2 = InputPort(name="in2", data_type=Text, hold=True)
        self.out = OutputPort(name="out", data_type=Text)

    def execute(self, grp):
        self.out.put_data(Text(self.in1.get_data(Text).values[0] + self.in2.get_data(Text).values[0]));
