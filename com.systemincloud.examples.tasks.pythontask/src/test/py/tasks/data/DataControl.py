from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Control import Control

@PythonTaskInfo
class DataControl(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in", data_type=Control)
        self.out = OutputPort(name="out", data_type=Control)

    def execute(self, grp):
        self.in_.get_data(Control);
        self.out.put_data(Control());
