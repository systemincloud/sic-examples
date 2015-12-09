from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Text import Text

@PythonTaskInfo(generator=True)
class Generator(PythonTask):

    def __init_ports__(self):
        self.out = OutputPort(name="out", data_type=Text)

    def generate(self):
        self.out.put_data(Text("Hello World"));
        self.sleep(3000);

