from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32

@PythonTaskInfo(atomic=False, generator=True)
class GeneratorNAtomicWith2SIn(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Int32)
        self.in2 = InputPort(name="in2", data_type=Int32)
        self.out = OutputPort(name="out", data_type=Int32)

    def __init__(self):
        self.left = -1
        self.right = -2

    def execute_async(self, async_in):
        if async_in is self.in1:
            self.left  = async_in.get_data(Int32).values[0]
        elif async_in is self.in2:
            self.right = async_in.get_data(Int32).values[0]

    def generate(self):
        if self.left == self.right:
            self.out.put_data(Int32(self.left))
        self.sleep(200)
