from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32
from sicpythontask.data.Text import Text

import threading
import random

@PythonTaskInfo(external_source=True)
class ExtSrcAtomicWith1SIn(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in", data_type=Int32)
        self.out = OutputPort(name="out", data_type=[Text, Int32])

    def runner_start(self):
        self.notify()

    def notify(self):
        self.external_data()
        threading.Timer(1, self.notify).start()

    def execute_ext_src(self):
        self.out.put_data(Text('External: ' + str(random.getrandbits(100))))

    def execute(self, grp):
        inData = self.in_.get_data(Int32)
        self.out.put_data(Int32(10*inData.values[0]))

