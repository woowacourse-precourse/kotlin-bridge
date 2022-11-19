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

        outputView.printResult(up, down, successOrFailure, numberOfAttempts)
    }
}
