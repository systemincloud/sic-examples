
library(R6)
library(sicrtask)

DataControl <- R6Class("DataControl",
  inherit = RTask,
  public = list(
    rtaskinfo = RTaskInfo$new(),
    in_ = NA,
    out = NA,
    initialize_ports = function() {
      self$in_ <- InputPort$new(name = "in")
      self$out <- OutputPort$new(name = "out")
    },
    initialize = function() {
      self$initialize_ports()
    },
    execute = function(grp) {
	  self$in_$get_data("Control");
	  self$out$put_data(Control$new());
	}
  ),
  private = list(
  )
)
