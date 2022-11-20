package bridge

import Utils.Constants.RETRY

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    // TODO 필드가 너무 많아질 것 같은데 리팩터 할 때 잘 나누기
    private val output = OutputView()
    private val input = InputView()
    private lateinit var bridgeMap: List<String> // todo 타입은 다시 생각
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
        // todo 어려울 것 같긴한데 인자 수 줄여보기
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

    fun gameOver(successOrFail: Boolean) {
        // 최종 게임 결과를 알려준다.
        output.printResult()
        output.printMap(bridgeMap, position - 1, successOrFail)
        output.printTryingCount(successOrFail, tryingCount)
    }
}
