package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    var up = ""
    var down = ""
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {
        println(up + "\n" + down + "\n")
    }

    fun upMap(result: String){
        up = "[ " + result.substring(0, result.length - 2)+ "]"
    }

    fun downMap(result: String){
        down = "[ " + result.substring(0, result.length - 2) + "]"
    }

    fun printStartMessage() {
        println(START_MESSAGE + "\n")
    }

    fun printGetBridgeSizeMessage() {
        println(GET_BRIDGE_SIZE_MESSAGE)
    }

    fun printGetMoveMessage() {
        println(GET_MOVE_MESSAGE)
    }

    fun printRetryMessage() {
        println(GET_RETRY_MESSAGE)
    }

    fun printResult(result : String, tryCount: Int) {
        println(RESULT_MESSAGE)
        printMap()
        println("\n" + RESULT_SUCCESS_OR_NOT_MESSAGE + result)
        println(RESULT_TRYCOUNT_MESSAGE + tryCount)
    }
}
