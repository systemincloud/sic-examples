from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32

import threading
import random

@PythonTaskInfo(external_source=True)
class ExtSrcMultiple(PythonTask):

    def __init_ports__(self):
        self.out = OutputPort(name="out", data_type=Int32)

    def runner_start(self):
        self.values = []
        self.notify()

    def notify(self):
        self.values.append(random.getrandbits(5))
        self.values.append(random.getrandbits(5))
        self.external_data(2)
        threading.Timer(1, self.notify).start()

    def execute_ext_src(self):
        self.out.put_data(Int32(self.values.pop()))

