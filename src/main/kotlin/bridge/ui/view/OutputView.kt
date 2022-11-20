package bridge.ui.view

import bridge.common.*
import bridge.domain.moving.MovingInfo


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * TODO : O, X 정보를 여기서 계산하는게 맞는지 생각,,
     */
    fun printMap(mapInfo: List<String>) {
        mapInfo.forEach { map ->
            print(map)
        }
    }

//    private fun checkBridge(bridgeCrossingInfo: List<Pair<MovingInfo, Boolean>>, bridgeNumber: Int) {
//        val round = bridgeCrossingInfo.size - 1
//
//        print("[ ")
//        bridgeCrossingInfo.forEachIndexed { curRound, (moving, isCrossed) ->
//            printCrossingResult(movingInfo = moving, bridgeNumber = bridgeNumber, isCrossed = isCrossed)
//
//            if (curRound == round) print(" ]\n")
//            else print(" | ")
//        }
//    }
//
//    /**
//     * 현재 출력해야 할 bridgeNumber이고, 건널 수 있으면 O 아니면 X
//     * 현재 출력해야 할 bridgeNumber가 아니라면 공백
//     */
//    private fun printCrossingResult(movingInfo: MovingInfo, bridgeNumber: Int, isCrossed: Boolean) {
//        if (movingInfo.bridgeNumber == bridgeNumber) {
//            if (isCrossed) print(CROSSED_SUCCESS_RESULT)
//            else print(CROSSED_FAIL_RESULT)
//        }
//
//        else print(" ")
//    }
//
    /**
     * 게임의 최종 결과를 출력하는 메서드
     */
    fun printResult(mapInfo: List<String>, gameSuccessResult: String, numberOfTry: Int) {
        print(FINAL_GAME_RESULT_MESSAGE)

        printMap(mapInfo = mapInfo)

        print(GAME_SUCCESSFUL_FORMAT.format(gameSuccessResult))
        print(GAME_TRY_NUMBER_FORMAT.format(numberOfTry))
    }

    fun printStartMessage() = print(GAME_START_MESSAGE)

    companion object {
        private val bridgeIndexInfo = hashMapOf(0 to BRIDGE_NUMBER_UP, 1 to BRIDGE_NUMBER_DOWN)
    }
}
