from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Text import Text

@PythonTaskInfo
class Atomic2SIn2AIn1Out(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Text)
        self.in2 = InputPort(name="in2", data_type=Text)
        self.in3 = InputPort(name="in3", data_type=Text, asynchronous=True)
        self.in4 = InputPort(name="in4", data_type=Text, asynchronous=True)
        self.out = OutputPort(name="out", data_type=Text)

    def execute_async(self, async_in):
        asynchInText = async_in.get_data(Text)
        self.out.put_data(Text("From port " + async_in.name + ": " + asynchInText.values[0]))

    def execute(self, grp):
        in1Text = self.in1.get_data(Text)
        in2Text = self.in2.get_data(Text)
        self.out.put_data(Text(in1Text.values[0] + " " + in2Text.values[0]))

