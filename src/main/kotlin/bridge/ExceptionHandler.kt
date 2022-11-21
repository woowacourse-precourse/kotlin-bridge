package bridge

import java.lang.IllegalArgumentException

object ExceptionHandler {
    fun checkValidMoving(location: String) {
        require(location == "U" || location == "D") { Message.InputViewEnum.INVALID_MSG }
    }

    fun checkValidRestart(restart: String) {
        require(restart == "Q" || restart == "R") { Message.InputViewEnum.INVALID_MSG }
    }

    fun checkValidState(state: Int) {
        try {
            require(state == 1 || state == 2) { Message.OutputViewEnum.INVALID_STATE }
        } catch (e: IllegalArgumentException) {
            print(e)
        }
    }

    fun checkValidLength(size: Int) {
        require(size in 3..20) { Message.InputViewEnum.INVALID_MSG }
    }
}