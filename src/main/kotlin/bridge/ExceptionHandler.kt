package bridge

object ExceptionHandler {
    fun checkValidMoving(location: String) {
        require(location == "U" || location == "D") { Message.InputViewEnum.INVALID_MSG }
    }
}