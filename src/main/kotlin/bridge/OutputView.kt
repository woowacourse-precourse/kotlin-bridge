package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printStartGame() {
        println(Message.START_BRIDGE_GAME)
    }

    fun printInputBridgeSize() {
        println(Message.PRINT_BRIDGE_SIZE)
    }

    fun printInputMoveBridge() {
        println(Message.PRINT_BRIDGE_MOVE)
    }

    fun printInputRetryOrExit() {
        println(Message.PRINT_GAME_COMMAND)
    }

    fun printException(inputType: InputType, message: String) {
        println(message)
        when(inputType) {
            InputType.BRIDGE_SIZE -> printInputBridgeSize()
            InputType.BRIDGE_MOVE -> printInputMoveBridge()
            InputType.BRIDGE_SIZE -> printInputRetryOrExit()
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(playerBridge: List<Pair<String, String>>) {
        var upLane = setPrintUpLane(playerBridge)
        upLane = upLane.replaceFirst(".$".toRegex(), "")
        upLane += "]"

        var downLane = setPrintDownLane(playerBridge)
        downLane = downLane.replaceFirst(".$".toRegex(), "")
        downLane += "]"

        println(upLane)
        println(downLane)
    }

    private fun setPrintUpLane(playerBridge: List<Pair<String, String>>): String {
        var printUpLane = "["
        for(i in playerBridge.indices) {
            if(playerBridge[i].first == "U") {
                printUpLane += " ${playerBridge[i].second} |"
                continue
            }
            printUpLane += "   |"
        }
        return printUpLane
    }

    private fun setPrintDownLane(playerBridge: List<Pair<String, String>>): String {
        var printUpLane = "["
        for(i in playerBridge.indices) {
            if(playerBridge[i].first == "D") {
                printUpLane += " ${playerBridge[i].second} |"
                continue
            }
            printUpLane += "   |"
        }
        return printUpLane
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(gameResult: Boolean, tryCount: Int, playerBridge: List<Pair<String, String>>) {
        println(Message.PRINT_GAME_RESULT)
        printMap(playerBridge)
        println("${Message.PRINT_IS_SUCCESS}: ${if(gameResult) Message.PRINT_SUCCESS else Message.PRINT_FAILED}")
        println("${Message.PRINT_TRY_COUNT}: $tryCount")
    }
}
