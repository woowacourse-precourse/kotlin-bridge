package bridge.view

import bridge.util.BridgeMoving

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printGameStart() {
        println(GAME_START_MESSAGE)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(userMovingResult: List<Pair<String, Boolean>>) {
        printUpperMap(userMovingResult)
        printLowerMap(userMovingResult)
    }

    private fun printUpperMap(userMovingResult: List<Pair<String, Boolean>>) {
        print(START_BRIDGE)
        userMovingResult.forEachIndexed { index, moving ->
            val userMoving = moving.first
            val isCrossable = moving.second
            if (userMoving != BridgeMoving.UP.character) print(UN_CHOSEN_BRIDGE)
            if (userMoving == BridgeMoving.UP.character && isCrossable) print(CROSSABLE_BRIDGE)
            if (userMoving == BridgeMoving.UP.character && !isCrossable) print(NON_CROSSABLE_BRIDGE)
            if (index != userMovingResult.size - 1) print(DIVIDING_LINE)
        }
        println(END_BRIDGE)
    }

    private fun printLowerMap(userMovingResult: List<Pair<String, Boolean>>) {
        print(START_BRIDGE)
        userMovingResult.forEachIndexed { index, moving ->
            val userMoving = moving.first
            val isCrossable = moving.second
            if (userMoving != BridgeMoving.DOWN.character) print(UN_CHOSEN_BRIDGE)
            if (userMoving == BridgeMoving.DOWN.character && isCrossable) print(CROSSABLE_BRIDGE)
            if (userMoving == BridgeMoving.DOWN.character && !isCrossable) print(NON_CROSSABLE_BRIDGE)
            if (index != userMovingResult.size - 1) print(DIVIDING_LINE)
        }
        println("${END_BRIDGE}\n")
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(gameTryCount: Int, isGameWin: Boolean, userMovingResult: List<Pair<String, Boolean>>) {
        println(GAME_END_MESSAGE)
        printUpperMap(userMovingResult)
        printLowerMap(userMovingResult)
        print(GAME_SUCCESS_OR_FAILURE_MESSAGE)
        if (isGameWin) println(GAME_SUCCESS_MESSAGE)
        println(GAME_FAILURE_MESSAGE)
        print("${GAME_TRY_COUNT_MESSAGE}gameTryCount")
    }

    companion object {
        const val START_BRIDGE = "["
        const val END_BRIDGE = "]"
        const val CROSSABLE_BRIDGE = " O "
        const val NON_CROSSABLE_BRIDGE = " X "
        const val UN_CHOSEN_BRIDGE = "   "
        const val DIVIDING_LINE = "|"
        const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n"
        const val GAME_END_MESSAGE = "최종 게임 결과"
        const val GAME_SUCCESS_OR_FAILURE_MESSAGE = "게임 성공 여부: "
        const val GAME_SUCCESS_MESSAGE = "성공"
        const val GAME_FAILURE_MESSAGE = "실패"
        const val GAME_TRY_COUNT_MESSAGE = "총 시도한 횟수:"
    }

}
