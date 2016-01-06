from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.data.Float32 import Float32

import numpy as np
import matplotlib.pyplot as plt
import warnings

@PythonTaskInfo
class ShowHistogram(PythonTask):

    def __init_ports__(self):
        self.in_ = InputPort(name="in", data_type=Float32)

    def __init__(self):
        plt.ion()
        self.fig = plt.figure()
        v = np.random.normal(10, 5, 10000)
        n, self.bins, self.patches = plt.hist(v, 100, normed=True, facecolor='green', alpha=0.75)
        
    def execute(self, grp):
        with warnings.catch_warnings():
            warnings.simplefilter("ignore")
            vs = self.in_.get_data(Float32).values
            v = np.array(vs)
            n, self.bins = np.histogram(v, self.bins, normed=True)
            for rect,h in zip(self.patches,n):
                rect.set_height(h)
            self.fig.canvas.draw()
            plt.pause(0.0001)
