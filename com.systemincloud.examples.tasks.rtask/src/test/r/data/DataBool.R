
library(R6)
library(sicrtask)

DataBool <- R6Class("DataBool",
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
	  in2Bool <- self.in2.get_data(Bool)
	  self$out$put_data(Bool$new(in1Bool.values[0] && in2Bool.values[0]))
    }
  ),
  private = list(
  )
)
