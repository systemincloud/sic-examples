from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Text import Text

@PythonTaskInfo
class DataText(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in", data_type=Text)
        self.out = OutputPort(name="out", data_type=Text)

    def execute(self, grp):
        inData = self.in_.get_data(Text)
        inRaw = inData.values
        print(inRaw)
        self.out.put_data(Text(inRaw))
