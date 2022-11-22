package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printStart() {
        println("다리 건너기 게임을 시작합니다.")
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeGame: BridgeGame) {
        printBridge(bridgeGame.bridge, bridgeGame.userChoice, Choice.Up)
        printBridge(bridgeGame.bridge, bridgeGame.userChoice, Choice.Down)
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame) {
        println("최종 게임 결과")
        printMap(bridgeGame)
        print("게임 성공 여부: ")
        when(bridgeGame.isSuccess()) {
            true -> println("성공")
            false -> println("실패")
        }
        println("총 시도한 횟수: ${bridgeGame.trial}")
    }

    private fun printBridge(bridge: List<String>, userChoice: List<String>, flag: Choice) {
        print("[ ")
        userChoice.forEachIndexed { index, s ->
            if (index != 0) print("| ")
            if (s != flag.string) print("  ")
            if (s == flag.string && s == bridge[index]) print("O ")
            if (s == flag.string && s != bridge[index]) print("X ")
        }
        println("]")
    }
}
