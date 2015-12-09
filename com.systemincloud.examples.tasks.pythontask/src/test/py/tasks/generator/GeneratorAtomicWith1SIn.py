from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32
from sicpythontask.data.Text import Text

@PythonTaskInfo(generator=True)
class GeneratorAtomicWith1SIn(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in", data_type=Int32)
        self.out = OutputPort(name="out", data_type=[Int32, Text])

    def generate(self):
        self.out.put_data(Text("Hello World"));
        self.sleep(1000);

    def execute(self, grp):
        inValue = self.in_.get_data(Int32).values[0]
        self.out.put_data(Int32(2*inValue))

