from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32

@PythonTaskInfo(generator=True)
class Generator(PythonTask):

    def __init_ports__(self):
        self.out1 = OutputPort(name="out1", data_type=Int32)
        self.out2 = OutputPort(name="out2", data_type=Int32)

    def __init__(self):
        self.i = 1
        self.side = True;

    def generate(self):
        self.sleep(1)
        if self.side:
            self.out2.put_data(Int32(self.i))
        else:
            self.out1.put_data(Int32(self.i))
        self.i += 1
        if self.i%5 == 0:
            self.side = not self.side