from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Bool import Bool

import threading
import random

@PythonTaskInfo(external_source=True)
class ExtSrc(PythonTask):

    def __init_ports__(self):
        self.out = OutputPort(name="out", data_type=Bool)

    def runner_start(self):
        self.notify()

    def notify(self):
        self.external_data()
        threading.Timer(1, self.notify).start()

    def execute_ext_src(self):
        self.out.put_data(Bool(bool(random.getrandbits(1))))

