from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Decimal import Decimal
from decimal import Decimal as D

@PythonTaskInfo
class DataDecimal(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in", data_type=Decimal)
        self.out = OutputPort(name="out", data_type=Decimal)

    def execute(self, grp):
        in1Data = self.in_.get_data(Decimal)
        dec = in1Data.values[0] * D(10)
        self.out.put_data(Decimal(dec))
