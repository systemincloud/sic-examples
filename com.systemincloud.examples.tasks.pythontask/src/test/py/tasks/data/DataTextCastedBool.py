from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Text import Text
from sicpythontask.data.Bool import Bool

@PythonTaskInfo
class DataTextCastedBool(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in", data_type=Bool)
        self.out = OutputPort(name="out", data_type=Text)

    def execute(self, grp):
        inData = self.in_.get_data(Text)
        self.out.put_data(Text(inData.value.upper()))

