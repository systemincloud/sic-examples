from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Control import Control
import time

@PythonTaskInfo(generator=True)
class GeneratorLong(PythonTask):

    def __init_ports__(self):
        self.out = OutputPort(name="out")

    def generate(self):
        self.sleep(3000)
        time.sleep(2)
        self.out.put_data(Control());
