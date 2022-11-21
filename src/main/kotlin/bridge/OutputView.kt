package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    fun printMap(game: BridgeGame) {
        println(game.gameToString())
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    fun printResult(success: Boolean, tries: Int, game: BridgeGame) {
        println("최종 게임 결과")
        printMap(game)
        print("게임 성공 여부: ")
        if(success) println("성공")
        else println("실패")
        print("총 시도한 횟수: $tries")
    }


}
