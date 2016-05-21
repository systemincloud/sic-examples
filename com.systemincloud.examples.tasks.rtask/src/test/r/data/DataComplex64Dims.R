
library(R6)
library(sicrtask)

DataComplex64Dims <- R6Class("DataComplex64Dims",
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
	  ret <- in1Data$values + in2Data$values
	  self$out$put_data(Complex32$new(ret, in1Data$dims))
    }
  ),
  private = list(
  )
)
