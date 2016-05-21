
library(R6)
library(sicrtask)

Constant2Add <- R6Class("Constant2Add",
  inherit = RTask,
  public = list(
    rtaskinfo = RTaskInfo$new(),
    in1 = NA,
    in2 = NA,
    out = NA,
    initialize_ports = function() {
      self$in1 <- InputPort$new(name = "in1", data_type = "Int32")
      self$in2 <- InputPort$new(name = "in2", data_type = "Int32")
      self$out <- OutputPort$new(name = "out", data_type = "Int32")
    },
    initialize = function() {
      self$initialize_ports()
    },
    execute = function(grp) {
	  sum = Int32$new(self$in1$get_data("Int32")$value + self$in2$get_data("Int32")$value)
	  self$out$put_data(sum)
	}
  ),
  private = list(
  )
)
