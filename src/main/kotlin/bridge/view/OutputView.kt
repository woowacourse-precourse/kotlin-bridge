package bridge.view

import bridge.GAME_OVER_MESSAGE
import bridge.GAME_SUCCESS_MESSAGE
import bridge.TRY_NUMBER_MESSAGE
import bridge.domain.MoveDirection

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(compareBridge: List<Pair<String, Boolean>>) {
        var printMapBridge = "["
        printMapBridge += nowBridgeResult(compareBridge, MoveDirection.UP.direction)
        printMapBridge += "]\n["
        printMapBridge += nowBridgeResult(compareBridge, MoveDirection.DOWN.direction)
        printMapBridge += "]"
        println(printMapBridge)
    }

    private fun nowBridgeResult(compareBridge: List<Pair<String, Boolean>>, nowState: String): String {
        var nowPrintMapBridge = ""
        for (compareBridgeIndex in compareBridge.indices) {
            nowPrintMapBridge += stateBridge(compareBridge[compareBridgeIndex], nowState)
            if (compareBridgeIndex != compareBridge.size - 1)
                nowPrintMapBridge += "|"
        }
        return nowPrintMapBridge
    }

    private fun stateBridge(nowCompareBridge: Pair<String, Boolean>, nowState: String): String {
        if (nowCompareBridge.first == nowState && nowCompareBridge.second)
            return " O "
        else if (nowCompareBridge.first == nowState)
            return " X "
        return "   "
    }

    fun printSuccess(gameSuccess: Boolean) {
        if (gameSuccess)
            println(GAME_SUCCESS_MESSAGE + "성공")
        else
            println(GAME_SUCCESS_MESSAGE + "실패")
    }

    fun printTryGameNumber(gameSuccess: Int) {
        println(TRY_NUMBER_MESSAGE +gameSuccess)
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(userBridge: List<String>, bridge: List<String>) {
        println(GAME_OVER_MESSAGE)
        val compareBridgeResult = mutableListOf<Pair<String, Boolean>>()
        for (userIndex in userBridge.indices) {
            if (bridge[userIndex] == userBridge[userIndex])
                compareBridgeResult.add(Pair(userBridge[userIndex], true))
            else
                compareBridgeResult.add(Pair(userBridge[userIndex], false))
        }
        printMap(compareBridgeResult)
    }
}
