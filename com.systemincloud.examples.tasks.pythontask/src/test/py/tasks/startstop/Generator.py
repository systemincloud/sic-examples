from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Control import Control

@PythonTaskInfo(generator=True)
class Generator(PythonTask):

    def __init_ports__(self):
        self.out = OutputPort(name="out")

    def runner_start(self):
        print('Generator : start')

    def generate(self):
        self.out.put_data(Control())

    def runner_stop(self):
        print('Generator : stop')
