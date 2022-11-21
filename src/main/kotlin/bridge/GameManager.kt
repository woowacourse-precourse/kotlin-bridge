package bridge

class GameManager {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeGame = BridgeGame()
    var bridge = listOf<String>()
    var bridgeSize = 0

    init {
        println("다리 건너기 게임을 시작합니다.")
        // 다리 길이 읽기
        bridgeSize = inputView.readBridgeSize()
        // 길이 읽은 거로 랜덤 다리 만들기
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    }

    fun play() {
        var position = 0
        var remains = bridge
        var upperBridge = mutableListOf<String>()
        var lowerBridge = mutableListOf<String>()

        while (true) {
            // 다리 건너기 시작
            val step = inputView.readMoving()// 입력 받기
            val moving = bridgeGame.move(step, bridge[position], position) // 움직이기

            remains = remains.drop(1)
            position++
            if (remains.isEmpty()) break
        }
    }
}