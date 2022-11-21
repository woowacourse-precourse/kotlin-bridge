package bridge

import bridge.app.App
import bridge.util.QUIT_COMMAND
import bridge.util.RESTART_COMMAND
import bridge.validator.BridgeGameValidator

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val bridgeMaker: BridgeMaker,
    private val outputView: OutputView,
    private val inputView: InputView,
): App {
    private lateinit var bridge: List<String>
    private var round = 0
    private var trialCount = 1

    fun bridgeSetUp() {
        println("다리 건너기 게임을 시작합니다.")
        val bridgeSize = inputView.readBridgeSize()
        val bridge = bridgeMaker.makeBridge(size = bridgeSize)
    }

    override fun start() {
        bridgeSetUp()
    }

    override fun process() {
        do {

        } while (round < bridge.size)
    }

    override fun quit() {
        TODO("Not yet implemented")
    }

    override fun retry() {
        TODO("Not yet implemented")
    }


    fun move(isMatched: Boolean): Int {
        return BridgeGameValidator.validateMoveOutput(isMatched)
    }



    fun retry(gameCommand: String): Boolean {
        if (gameCommand == QUIT_COMMAND) {
            println("종료")
        }
        if (gameCommand == RESTART_COMMAND) return true
        return false
    }

}
