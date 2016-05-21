
library(R6)
library(sicrtask)

DataBoolDims <- R6Class("DataBoolDims",
  inherit = RTask,
  public = list(
    rtaskinfo = RTaskInfo$new(),
    in1 = NA,
    in2 = NA,
    out = NA,
    initialize_ports = function() {
      self$in1 <- InputPort$new(name = "in1", data_type = "Bool")
      self$in2 <- InputPort$new(name = "in2", data_type = "Bool")
      self$out <- OutputPort$new(name = "out", data_type = "Bool")
    },
    initialize = function() {
      self$initialize_ports()
    },
    execute = function(grp) {
	  in1Bool <- self$in1$get_data("Bool")
	  in2Bool <- self$in2$get_data("Bool")
	  ret <- in1Bool$values & in2Bool$values
	  self$out$put_data(Bool$new(ret, in1Bool$dims))
	}
  ),
  private = list(
  )
)
