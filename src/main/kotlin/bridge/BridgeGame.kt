package bridge

import Utils.Constants.RETRY

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val output = OutputView()
    private val input = InputView()
    private lateinit var bridgeMap: List<String>
    private var bridgeSize = 0
    private var tryingCount = 1
    private var position = 0 // user의 현재 위치

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    fun start() {
        output.printGameStart()

        output.printInputBridgeSize()
        bridgeSize = input.readBridgeSize()

        bridgeMap = List(bridgeSize) { "" }
        bridgeMap = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    }

    fun move(): Boolean {
        output.printInputMoving()
        val moving = input.readMoving()
        val isMovable = calculateIsMovable(moving, position)

        output.printMap(bridgeMap, position, isMovable)
        position++
        return isMovable
    }
    private fun calculateIsMovable(moving: String, position: Int): Boolean {
        return bridgeMap[position] == moving
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry(): Boolean {
        output.printRetry()
        val command = input.readGameCommand()
        if (command == RETRY) {
            tryingCount++
            position = 0
        }

        return command == RETRY
    }

    fun arrivedBridgeEnd(): Boolean {
        return position == bridgeSize
    }

    fun gameOver(isSuccess: Boolean) {
        output.printResult()
        output.printMap(bridgeMap, position - 1, isSuccess)
        output.printTryingCount(isSuccess, tryingCount)
    }
}
