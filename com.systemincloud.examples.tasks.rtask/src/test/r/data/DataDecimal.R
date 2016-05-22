
library(R6)
library(sicrtask)

library(Rmpfr)

DataDecimal <- R6Class("DataDecimal",
  inherit = RTask,
  public = list(
    rtaskinfo = RTaskInfo$new(),
    in_ = NA,
    out = NA,
    initialize_ports = function() {
      self$in_ <- InputPort$new(name = "in", data_type = "Decimal")
      self$out <- OutputPort$new(name = "out", data_type = "Decimal")
    },
    initialize = function() {
      self$initialize_ports()
    },
    execute = function(grp) {
	  inData <- self$in_$get_data("Decimal")
	  dec <- in1Data$values[0] * mpfr(10)
	  self$out$put_data(Decimal$new(dec))
    }
  ),
  private = list(
  )
)
