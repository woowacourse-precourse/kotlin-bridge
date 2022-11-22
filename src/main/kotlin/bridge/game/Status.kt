package bridge.game

import bridge.resources.FAIL

data class Status
    ( var tryCount:Int=1,
      var success:String= FAIL) {
}