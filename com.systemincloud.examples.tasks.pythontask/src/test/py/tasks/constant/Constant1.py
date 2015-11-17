from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Text import Text

@PythonTaskInfo(constant=True)
class Constant1(PythonTask):

    def __init_ports__(self):
        self.out = OutputPort(name="Out", data_type=Text)

    def __init__(self):
        print("yyyyy")

    def execute(self, grp):
        print("xxxxx")
        self.logger.error("vvvv")
        self.out.put_data(Text("Hello World"))
