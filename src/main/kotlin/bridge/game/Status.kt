package bridge.game

import bridge.resources.FAIL

/**
 * 시도 횟수와 성공여부 데이터를 담는 data class
 */
data class Status
    ( var tryCount:Int=1,
      var success:String= FAIL) {
}