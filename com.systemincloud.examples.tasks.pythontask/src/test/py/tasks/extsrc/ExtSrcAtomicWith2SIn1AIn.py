from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32
from sicpythontask.data.Text import Text

import threading
import random

@PythonTaskInfo(external_source=True)
class ExtSrcAtomicWith2SIn1AIn(PythonTask):

    def __init_ports__(self):
        self.in1 = InputPort(name="in1", data_type=Int32, asynchronous=True)
        self.in2 = InputPort(name="in2", data_type=Int32)
        self.in3 = InputPort(name="in3", data_type=Int32)
        self.out = OutputPort(name="out", data_type=Text)

    def runner_start(self):
        self.notify()

    def notify(self):
        self.external_data()
        threading.Timer(1, self.notify).start()

    def execute_async(self, async_in):
        self.out.put_data(Text("From " + async_in.name + ": " + str(async_in.get_data(Int32).values[0])));


    def execute_ext_src(self):
        self.out.put_data(Text("External: " + str(random.getrandbits(100))))

    def execute(self, grp):
        self.out.put_data(Text("From In2: " + str(self.in2.get_data(Int32).values[0])));

