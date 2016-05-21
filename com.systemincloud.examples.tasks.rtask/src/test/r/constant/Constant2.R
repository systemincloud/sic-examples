
library(R6)
library(sicrtask)

Constant2 <- R6Class("Constant2",
  inherit = RTask,
  public = list(
    rtaskinfo = RTaskInfo$new(constant = TRUE),
    out = NA,
    initialize_ports = function() {
      self$out <- OutputPort$new(name = "out", data_type = "Int32")
    },
    initialize = function() {
      self$initialize_ports()
    },
    execute = function(grp) {
	  self$out$put_data(Int32$new(3))
    }
  ),
  private = list(
  )
)
