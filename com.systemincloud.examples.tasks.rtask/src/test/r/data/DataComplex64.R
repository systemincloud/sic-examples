
library(R6)
library(sicrtask)

DataComplex64 <- R6Class("DataComplex64",
  inherit = RTask,
  public = list(
    rtaskinfo = RTaskInfo$new(),
    in1 = NA,
    in2 = NA,
    out = NA,
    initialize_ports = function() {
      self$in1 <- InputPort$new(name = "in1", data_type = "Complex64")
      self$in2 <- InputPort$new(name = "in2", data_type = "Complex64")
      self$out <- OutputPort$new(name = "out", data_type = "Complex64")
    },
    initialize = function() {
      self$initialize_ports()
    },
    execute = function(grp) {
	  in1Data <- self$in1$get_data("Complex64")
	  in2Data <- self$in2$get_data("Complex64")
	  self$out$put_data(Complex32$new(in1Data$value + in2Data$value))
	}
  ),
  private = list(
  )
)
