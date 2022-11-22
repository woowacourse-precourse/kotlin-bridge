package bridge.domain.game

import bridge.common.*
import bridge.domain.game.service.GameService
import bridge.domain.maker.BridgeMaker
import bridge.domain.mediator.BridgeGameViewMediator
import bridge.domain.moving.Moving
import bridge.domain.calculator.BridgeCrossingCalculator

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val bridgeGameViewMediator: BridgeGameViewMediator,
    private val bridgeMaker: BridgeMaker
) : GameService {
    private lateinit var bridge: List<String>
    private var round = 0 // 현재 건널 다리 라운드
    private var numberOfTry = 1 // 시도 횟수

    override fun play() {
        initGame()
        crossBridge()
    }

    private fun initGame() {
        val bridgeSize = bridgeGameViewMediator.readBridgeSize()

        bridge = bridgeMaker.makeBridge(size = bridgeSize)

        bridgeGameViewMediator.printStartMessage()
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
        if (BridgeCrossingCalculator.isCrossingFail()) {
            val command = bridgeGameViewMediator.readGameCommand()
            checkGameCommand(command = command)
        }
    }

    /**
     * 마지막 라운드가 끝나고
     * 다리를 모두 건넜는지를 체크한다.
     */
    private fun checkLastRound() {
        if (round == bridge.size) {
            if (!BridgeCrossingCalculator.isCrossingFail()) {
                end()
                return
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    private fun move() {
        val moving = bridgeGameViewMediator.readMoving()
        checkMoving(moving = moving)

        bridgeGameViewMediator.printMap(gameMap = BridgeCrossingCalculator.getCurrentMap())

        round++
    }

    private fun checkMoving(moving: String) {
        val userMoving = if (moving == MOVING_UP_CODE) Moving.UP else Moving.DOWN
        val isCrossed = (moving == bridge[round])

        BridgeCrossingCalculator.updateBridgeCrossingInfo(userMoving = userMoving, isCrossed = isCrossed)
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
        BridgeCrossingCalculator.clearBridgeCrossingInfo()

        numberOfTry++
        round = 0
    }

    /**
     * 게임이 끝났을 때 실행되는 메서드
     */
    override fun end() {
        val gameSuccessResult = BridgeCrossingCalculator.calculateFinalGameResult()

        bridgeGameViewMediator.printResult(
            mapInfo = BridgeCrossingCalculator.getCurrentMap(),
            gameSuccessResult = gameSuccessResult,
            numberOfTry = numberOfTry
        )
    }
}
