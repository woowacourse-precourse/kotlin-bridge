package bridge

class OutputView {
    private val bridgeGame = BridgeGame()

    fun printMovingList(space: String, bridgeList: List<String>) {
        val movingList = bridgeGame.move(space, bridgeList)
        val upList = bridgeGame.separateList(movingList, BridgeGame.UP)
        val downList = bridgeGame.separateList(movingList, BridgeGame.DOWN)

        printMap(upList, downList)
    }

    fun printResult(up: List<String>, down: List<String>, successOrFailure: String, numberOfAttempts: Int) {
        println("최종 게임 결과")
        printMap(up, down)
        println("게임 성공 여부: $successOrFailure")
        print("총 시도한 횟수: $numberOfAttempts")
    }

    private fun printMap(up: List<String>, down: List<String>) {
        println(bridgeGame.transformedList(up))
        println(bridgeGame.transformedList(down))
        println()
    }
}
