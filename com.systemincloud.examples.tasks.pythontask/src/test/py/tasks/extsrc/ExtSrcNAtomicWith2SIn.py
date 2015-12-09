from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32

import threading
import random

@PythonTaskInfo(atomic=False, external_source=True)
class ExtSrcNAtomicWith2SIn(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Int32)
        self.in2 = InputPort(name="in2", data_type=Int32)
        self.out = OutputPort(name="out", data_type=Int32)

    def runner_start(self):
        self.notify()

    def notify(self):
        self.external_data()
        threading.Timer(1, self.notify).start()

    def execute_async(self, async_in):
        self.out.put_data(Int32(async_in.get_data(Int32).values[0]));

    def execute_ext_src(self):
        self.out.put_data(Int32(random.getrandbits(5)))

