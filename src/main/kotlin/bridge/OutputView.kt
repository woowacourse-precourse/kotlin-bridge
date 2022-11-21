package bridge

import Utils.Constants.DOWN
import Utils.Constants.UP

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeMap: List<String>, position: Int, isMovable: Boolean) {
        // 지나온 경로 만들어주기 (하나만 만들어주면 반대로 만들면 됨.)
        var upperBridge = makeUpperPastPath(bridgeMap, position, isMovable)
        val lowerBridge = upperBridge.replace(O, BLANK).replace(X, BLANK)
            .replace(FLAG_DOWN_O, O).replace(FLAG_DOWN_X, X)
        upperBridge = upperBridge.replace(FLAG_DOWN_O, BLANK).replace(FLAG_DOWN_X, BLANK)

        println(MAP_BRACKET.format(upperBridge))
        println(MAP_BRACKET.format(lowerBridge))
        println()
    }

    private fun makeUpperPastPath(bridgeMap: List<String>, position: Int, isMovable: Boolean): String {
        val upperBridge = StringBuilder()
        for (i in 0 until position) {
            if (bridgeMap[i] == UP) upperBridge.append(O)
            else if (bridgeMap[i] == DOWN) upperBridge.append(FLAG_DOWN_O)

            upperBridge.append(SECTOR)
        }
        val lastPath = getLastPath(bridgeMap[position], isMovable)
        upperBridge.append(lastPath)

        return upperBridge.toString()
    }

    private fun getLastPath(lastPath: String, isMovable: Boolean): String {
        var lastMoving = String()
        when (lastPath) {
            UP -> lastMoving = if (isMovable) O else FLAG_DOWN_X

            DOWN -> lastMoving = if (isMovable) FLAG_DOWN_O else X
        }

        return lastMoving
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {
        println(GAME_OVER_RESULT)
    }

    fun printTryingCount(isSuccess: Boolean, count: Int) {
        val result = if (isSuccess) SUCCESS else FAIL

        println(GAME_SUCCESS_OR_FAIL.format(result))
        println(TOTAL_TRYING_COUNT.format(count))
    }

    fun printGameStart() {
        println(GAME_START)
        println()
    }

    fun printInputBridgeSize() {
        println(INPUT_BRIDGE_SIZE)
    }

    fun printInputMoving() {
        println(INPUT_MOVING)
    }

    fun printRetry() {
        println(ASK_RETRY)
    }

    companion object {
        // output에서만 사용할거니까 message는 없애자
        const val GAME_START = "다리 건너기 게임을 시작합니다."
        const val INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
        const val GAME_OVER_RESULT = "최종 게임 결과"
        const val GAME_SUCCESS_OR_FAIL = "게임 성공 여부: %s"
        const val TOTAL_TRYING_COUNT = "총 시도한 횟수: %d"
        const val INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val ASK_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

        const val MAP_BRACKET = "[ %s ]"

        const val O = "O"
        const val X = "X"
        const val SECTOR = " | "
        const val BLANK = " "
        const val FLAG_DOWN_O = "1"
        const val FLAG_DOWN_X = "2"

        const val SUCCESS = "성공"
        const val FAIL = "실패"
    }
}
