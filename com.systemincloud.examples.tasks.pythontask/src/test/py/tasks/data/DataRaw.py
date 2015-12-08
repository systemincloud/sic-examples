from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Raw import Raw

@PythonTaskInfo
class DataRaw(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in", data_type=Raw)
        self.out = OutputPort(name="out", data_type=Raw)

    def execute(self, grp):
        inData = self.in_.get_data(Raw)
        inRaw = inData.values
        self.out.put_data(Raw(inRaw))
