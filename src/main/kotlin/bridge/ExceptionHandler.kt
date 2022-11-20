package bridge

object ExceptionHandler {
    fun checkValidMoving(location: String) {
        require(location == "U" || location == "D") { Message.InputViewEnum.INVALID_MSG }
    }

    fun checkValidRestart(restart: String) {
        require(restart == "Q" || restart == "R") { Message.InputViewEnum.INVALID_MSG }
    }
}