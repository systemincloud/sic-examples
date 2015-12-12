from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Text import Text

@PythonTaskInfo(atomic=False)
class GeneratorLongPrint(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in")
        self.time = InputPort(name="time")
        self.out = OutputPort(name="out", data_type=Text)

    def execute_async(self, async_in):
        if async_in is self.time:
            self.out.put_data(Text("+"));
        elif async_in is self.in_:
            self.out.put_data(Text("-----+"));

