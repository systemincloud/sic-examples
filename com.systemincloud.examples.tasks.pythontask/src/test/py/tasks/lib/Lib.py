from sicpythontask.PythonTaskInfo import PythonTaskInfo
from sicpythontask.PythonTask import PythonTask
from sicpythontask.InputPort import InputPort
from sicpythontask.OutputPort import OutputPort
from sicpythontask.data.Int32 import Int32
from sicpythontask.data.Text import Text
from sympy.parsing.sympy_parser import parse_expr
from sympy.core.symbol import symbols

@PythonTaskInfo
class Lib(PythonTask):

    def __init_ports__(self):
        self.x = InputPort(name="x", data_type=Int32)
        self.fun = InputPort(name="fun", data_type=Text)
        self.out = OutputPort(name="out", data_type=Int32)

    def execute(self, grp):
        x = symbols('x')
        x_val = self.x.get_data(Int32).values[0]
        fun = self.fun.get_data(Text).values[0]
        expr = parse_expr(fun)
        res = expr.subs(x, x_val)
        self.out.put_data(Int32(int(res)))

