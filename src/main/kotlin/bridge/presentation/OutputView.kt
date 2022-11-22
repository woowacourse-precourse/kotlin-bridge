package bridge.presentation

import bridge.BridgeGame
import bridge.utils.BridgeMessage.GAME_COMMAND_MESSAGE
import bridge.utils.BridgeMessage.GAME_RESULT_MESSAGE
import bridge.utils.BridgeMessage.GET_MOVING_MESSAGE
import bridge.utils.BridgeMessage.START_GAME_MESSAGE

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    private var totalCount = 0
    /**
     * 게임 시작 문구 및 다리 길이 입력 요구 문구 출력하기
     */
    fun printStartGame() {
        println(START_GAME_MESSAGE)
    }
    /**
     * 이동할 칸 입력 요구 문구 출력하기
     */
    fun printGetMoving() {
        println(GET_MOVING_MESSAGE)
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    fun printMap(bridgeGame: BridgeGame) {
        println(bridgeGame.toUpBridgeMap())
        println(bridgeGame.toDownBridgeMap())
    }
    fun printGameCommand() {
        println(GAME_COMMAND_MESSAGE)
        totalCount += 1
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    fun printResult(
        bridgeGame: BridgeGame,
        successCode: String
    ) {
        if (successCode == "성공") totalCount += 1
        println(GAME_RESULT_MESSAGE)
        printMap(bridgeGame)
        println("\n게임 성공 여부: $successCode")
        println("총 시도한 횟수: $totalCount")
    }
}
