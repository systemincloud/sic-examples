from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort

@PythonTaskInfo
class Task(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in")

    def runner_start(self):
        print('Task : start')

    def execute(self, grp):
        print('Task : execute')


    def runner_stop(self):
        print('Task : stop')
