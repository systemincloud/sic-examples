from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Text import Text

@PythonTaskInfo(constant=True)
class Constant1(PythonTask):

    def __init_ports__(self):
        self.out = OutputPort(name="Out", data_type=Text)

    def execute(self, grp):
        self.out.put_data(Text("Hello World"))
