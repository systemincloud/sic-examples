
library(R6)
library(sicrtask)

Constant1 <- R6Class("Constant1",
  inherit = RTask,
  public = list(
    rtaskinfo = RTaskInfo$new(constant = TRUE),
    out = NA,
    initialize_ports = function() {
      self$out <- OutputPort$new(name = "out", data_type = "Bool")
    },
    initialize = function() {
      self$initialize_ports()
    },
    execute = function(grp) {
	  self$out$put_data(Bool$new(c(FALSE, TRUE), c(1, 2)))
    }
  ),
  private = list(
  )
)
