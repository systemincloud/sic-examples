from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.SicParameter import SicParameter
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Float32 import Float32

import numpy as np

@PythonTaskInfo(generator=True)
@SicParameter(name="mu")
@SicParameter(name="sigma")
class RandomGenerator(PythonTask):

    def __init_ports__(self):
        self.out = OutputPort(name="out", data_type=Float32)
        
    def generate(self):
        self.sleep(100)
        mu    = int(self.get_parameter("mu"))
        sigma = int(self.get_parameter("sigma"))
        v = np.random.normal(mu, sigma, 10000)
        self.out.put_data(Float32(v.tolist(),[1, len(v)]))
     
