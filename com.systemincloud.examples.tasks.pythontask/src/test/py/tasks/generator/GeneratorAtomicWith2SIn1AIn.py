from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32
from sicpythontask.data.Control import Control

@PythonTaskInfo(generator=True)
class GeneratorAtomicWith2SIn1AIn(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Int32)
        self.in2 = InputPort(name="in2", data_type=Int32)
        self.in3 = InputPort(name="in3", data_type=Control, asynchronous=True)
        self.out = OutputPort(name="out", data_type=Int32)

    def runner_start(self):
        self.on = True

    def execute_async(self, async_in):
        self.on = not self.on

    def generate(self):
        if self.on:
            self.out.put_data(Int32(637343730));
        self.sleep(500);

    def execute(self, grp):
        self.out.put_data(Int32(self.in1.get_data(Int32).values[0] + self.in2.get_data(Int32).values[0]));
