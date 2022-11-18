package bridge

class OutputView() {
    fun printGameStart() {
        println("다리 건너기 게임을 시작합니다.\n")
    }

    fun printBridgeLength() {
        println("다리의 길이를 입력해주세요.")
    }

    fun printSelectBlock() {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    fun printRestart() = println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")

    fun printMap(bridgeGame: BridgeGame) {
        val bridgeState = bridgeGame.makeBridge
        val userState = bridgeGame.moveBlock

        printBridgeState(bridgeState, userState, "U")
        printBridgeState(bridgeState, userState, "D")
        println()
    }

    private fun printBridgeState(bridgeState: List<String>, userState: List<String>, flag: String) {
        print("[ ")
        userState.forEachIndexed { index, state ->
            if(index != 0) print(" | ")
            if(state != flag) print(" ")
            if(state == flag && state == bridgeState[index]) print("O")
            if(state == flag && state != bridgeState[index]) print("X")
        }
        println(" ]")
    }

    fun printResult(bridgeGame: BridgeGame) {
        println("최종 게임 결과")
        printMap(bridgeGame)
        print("게임 성공 여부: ")
        when(bridgeGame.isSuccess()) {
            true -> println("성공")
            false -> println("실패")
        }
        println("총 시도한 횟수: ${bridgeGame.tryCnt}")
    }
}
