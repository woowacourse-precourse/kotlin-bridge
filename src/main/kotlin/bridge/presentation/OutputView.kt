package bridge.presentation

import bridge.BridgeGame

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    var totalCount = 0
    /**
     * 게임 시작 문구 및 다리 길이 입력 요구 문구 출력하기
     */
    fun printStartGame() {
        println("다리 건너기 게임을 시작합니다.\n")
        println("다리 길이를 입력해주세요.")
    }
    /**
     * 이동할 칸 입력 요구 문구 출력하기
     */
    fun printGetMoving() {
        println()
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    fun printMap(bridgeGame: BridgeGame) {
        println(bridgeGame.up.toString().replace(", ","|"))
        println(bridgeGame.down.toString().replace(", ","|"))
    }
    fun printGameCommand() {
        println()
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
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
        println("최종 게임 결과")
        printMap(bridgeGame)
        println("게임 성공 여부: $successCode")
        println("총 시도한 횟수: $totalCount")
    }
}
