package bridge

fun main() {
    val inputView = InputView()
    val numberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(numberGenerator)
    val outputView = OutputView()
    val bridgeGame = BridgeGame()
    var numberOfAttempts = 0
    var successOrFailure = ""
    val up = BridgeGame.getUpList()
    val down = BridgeGame.getDownList()

    println("다리 건너기 게임을 시작합니다.\n")

    println("다리의 길이를 입력해주세요.")
    val size = inputView.readBridgeSize()
    val bridge = bridgeMaker.makeBridge(size)

    while (true) {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val space = inputView.readMoving()
        val movingList = bridgeGame.move(space, bridge)
        val upList = movingList.filter { it.key == "U" }.values.flatten()
        val downList = movingList.filter { it.key == "D" }.values.flatten()
        outputView.printMap(upList, downList)

        if (BridgeGame.success(bridge)) {
            numberOfAttempts += 1
            successOrFailure = "성공"
            outputView.printResult(up, down, successOrFailure, numberOfAttempts)
            break
        }

        if (BridgeGame.failure()) {
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
            val isRetry = inputView.readGameCommand()

            numberOfAttempts += 1
            if (isRetry == "R") {
                bridgeGame.retry()
                continue
            } else if (isRetry == "Q") {
                successOrFailure = "실패"
                outputView.printResult(up, down, successOrFailure, numberOfAttempts)
                break
            }
        }
    }
}
