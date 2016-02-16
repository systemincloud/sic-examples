
library(R6)
library(sicrtask)

Break <- R6Class("Break",
  inherit = RTask,
  public = list(
    rtaskinfo <- RTaskInfo$new(),
    in1 = NA,
    initialize_ports = function() {
      self$in1 <- InputPort$new(name = "in1", data_type = Int32)
    },
    initialize = function() {
      self$initialize_ports()
    },
    execute = function(grp) {
	  i = self$in1$get_data(Int32)$values[0]
	  if( i == 3 ) self$exit_runner()
	},
  ),
  private = list(
  )
)
