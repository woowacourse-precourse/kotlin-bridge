package bridge

fun main() {
    val bridge = Bridge()
    val outputView = OutputView()
    val bridgeGame = BridgeGame()
    val up = BridgeGame.getUpList()
    val down = BridgeGame.getDownList()
    var numberOfAttempts = 0
    var successOrFailure = ""

    println("다리 건너기 게임을 시작합니다.\n")
    println("다리의 길이를 입력해주세요.")
    val bridgeList = bridge.make()

    while (true) {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val space = bridge.selectToMove()

        bridge.printMovingList(space, bridgeList)

        if (BridgeGame.successConditions(bridgeList)) {
            numberOfAttempts += 1
            successOrFailure = "성공"
            outputView.printResult(up, down, successOrFailure, numberOfAttempts)
            break
        }

        if (BridgeGame.failureConditions()) {
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
            val retryOrQuit = bridge.selectRetryOrQuit()

            numberOfAttempts += 1
            if (retryOrQuit == "R") {
                bridgeGame.retry()
                continue
            } else if (retryOrQuit == "Q") {
                successOrFailure = "실패"
                outputView.printResult(up, down, successOrFailure, numberOfAttempts)
                break
            }
        }
    }
}
