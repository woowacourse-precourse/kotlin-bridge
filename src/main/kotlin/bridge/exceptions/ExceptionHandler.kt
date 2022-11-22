package bridge.exceptions

import bridge.consol.Message.DOWN
import bridge.consol.Message.NOT_INCLUSIVE_RANGE
import bridge.consol.Message.NOT_QUIT_OR_RETRY
import bridge.consol.Message.NOT_UP_OR_DOWN
import bridge.consol.Message.QUIT
import bridge.consol.Message.RETRY
import bridge.consol.Message.UP

object ExceptionHandler {

    fun checkSize(num: Int) :Int{
        require(num in 3..20) { NOT_INCLUSIVE_RANGE }
        return num
    }

    fun checkUpDown(str: String) {
        require(str == UP || str == DOWN) { NOT_UP_OR_DOWN }
    }

    fun checkCommand(str: String) {
        require(str == QUIT || str == RETRY) { NOT_QUIT_OR_RETRY }
    }


}