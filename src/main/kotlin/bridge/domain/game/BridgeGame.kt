package bridge.domain.game

import bridge.common.*
import bridge.domain.game.service.GameService
import bridge.domain.maker.BridgeMaker
import bridge.domain.moving.MovingInfo
import bridge.domain.processor.BridgeCrossingProcessor
import bridge.ui.view.InputView
import bridge.ui.view.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val bridgeMaker: BridgeMaker
): GameService {
    private lateinit var bridge: List<String>
    // private val bridgeCrossingInfo = mutableListOf<Pair<MovingInfo, Boolean>>()
    private var round = 0 // 다리 건너는 라운드
    private var numberOfTry = 1 // 시도 횟수

    override fun play() {
        initGame()

        crossBridge()
    }

    private fun initGame() {
        val bridgeSize = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(size = bridgeSize)

        outputView.printStartMessage()
        println(bridge)
    }

    private fun crossBridge() {
        do {
            move()

            checkCrossingFail()

            checkLastRound()
        } while (round < bridge.size)
    }

    /**
     * 다리를 건너지 못했을 때
     * 재시도 여부를 물어본다.
     */
    private fun checkCrossingFail() {
        if (BridgeCrossingProcessor.isCrossingFail()) {
            val command = inputView.readGameCommand()
            checkGameCommand(command = command)
        }
    }

    /**
     * 마지막 라운드가 끝나고
     * 다리를 모두 건넜는지를 체크한다.
     */
    private fun checkLastRound() {
        if (round == bridge.size) {
            if (!BridgeCrossingProcessor.isCrossingFail()) {
                end()
                return
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    private fun move() {
        val moving = inputView.readMoving()
        checkMoving(moving = moving)
        outputView.printMap(BridgeCrossingProcessor.getCurrentMap())
        round++
    }

    private fun checkMoving(moving: String) {
        val userMovingInfo = if (moving == MOVING_UP_CODE) MovingInfo.UP else MovingInfo.DOWN
        val isCrossed = (moving == bridge[round])
        BridgeCrossingProcessor.updateBridgeCrossingInfo(userMovingInfo, isCrossed)
    }

    private fun checkGameCommand(command: String) {
        when (command) {
            GAME_RESTART_CODE -> retry()
            GAME_QUIT_CODE -> {
                end()
                return
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    override fun retry() {
        BridgeCrossingProcessor.clearBridgeCrossingInfo()

        numberOfTry++
        round = 0
    }

    /**
     * 게임이 끝났을 때 실행되는 메서드
     */
    override fun end() {
        val gameSuccessResult = if (BridgeCrossingProcessor.isCrossingFail()) FAIL_MESSAGE else SUCCESS_MESSAGE
        outputView.printResult(BridgeCrossingProcessor.getCurrentMap(), gameSuccessResult, numberOfTry)
    }

    // private fun isFailCrossing(): Boolean = bridgeCrossingInfo.any { (_, isCrossed) -> !isCrossed }
}
