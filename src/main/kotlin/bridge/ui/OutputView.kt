package bridge.ui

import bridge.enums.GameMessages
import bridge.enums.Status

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridge: List<String>, progress: List<Status>) {
        var bridgeTop = drawMapTop(bridge, progress) + "]"
        var bridgeBottom = drawMapBottom(bridge, progress) + "]"
        println(bridgeTop)
        println(bridgeBottom)
    }

    private fun drawMapTop(bridge: List<String>, progress: List<Status>): String {
        var bridgeTop = "["
        for (index in progress.indices) {
            bridgeTop += drawCircleOrBlankOnTop(progress[index], bridge[index])
            if ((index < progress.size - 1) and (progress[index] != Status.WRONG)) {
                bridgeTop += drawDivider()
            }
        }
        return bridgeTop
    }

    private fun drawCircleOrBlankOnTop(status: Status, bridge: String): String {
        if ((status == Status.CORRECT) and (bridge == "U")) {
            return " O "
        }
        if ((status == Status.WRONG) and (bridge == "D")) {
            return " X "
        }
        return "   "
    }

    private fun drawDivider(): String {
        return "|"
    }

    private fun drawMapBottom(bridge: List<String>, progress: List<Status>): String {
        var bridgeBottom = "["
        for (index in progress.indices) {
            bridgeBottom += drawCircleOrBlankOnBottom(progress[index], bridge[index])
            if ((index < progress.size - 1) and (progress[index] != Status.WRONG)) {
                bridgeBottom += drawDivider()
            }
        }
        return bridgeBottom
    }

    private fun drawCircleOrBlankOnBottom(status: Status, bridge: String): String {
        if ((status == Status.CORRECT) and (bridge == "D")) {
            return " O "
        }
        if ((status == Status.WRONG) and (bridge == "U")) {
            return " X "
        }
        return "   "
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    fun printStart() {
        println(GameMessages.START.toString())
    }

    fun printInputBridgeSize() {
        println(GameMessages.INPUT_BRIDGE_SIZE.toString())
    }

    fun printMove() {
        println(GameMessages.INPUT_UP_DOWN.toString())
    }
}
