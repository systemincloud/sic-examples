
library(R6)
library(sicrtask)

DataComplex32 <- R6Class("DataComplex32",
  inherit = RTask,
  public = list(
    rtaskinfo = RTaskInfo$new(),
    in1 = NA,
    in2 = NA,
    out = NA,
    initialize_ports = function() {
      self$in1 <- InputPort$new(name = "in1", data_type = "Complex32")
      self$in2 <- InputPort$new(name = "in2", data_type = "Complex32")
      self$out <- OutputPort$new(name = "out", data_type = "Complex32")
    },
    initialize = function() {
      self$initialize_ports()
    },
    execute = function(grp) {
	  in1Data <- self$in1$get_data("Complex32")
	  in2Data <- self$in2$get_data("Complex32")
	  self$out$put_data(Complex32$new(in1Data$value + in2Data$value))
	}
  ),
  private = list(
  )
)
