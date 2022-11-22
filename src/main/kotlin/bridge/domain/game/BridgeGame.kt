package bridge.domain.game

import bridge.common.*
import bridge.BridgeMaker
import bridge.domain.mediator.BridgeGameViewMediator
import bridge.domain.moving.Moving
import bridge.domain.calculator.BridgeCrossingCalculator
import bridge.domain.mediator.type.InputType

/**
 * 다리 건너기 게임 상황을 관리하는 클래스
 */
class BridgeGame(
    private val bridgeGameViewMediator: BridgeGameViewMediator,
    private val bridgeMaker: BridgeMaker
) : GameService {
    private lateinit var bridge: List<String>
    private var position = 0 // 현재 유저의 다리 상의 위치
    private var numberOfTry = 1 // 시도 횟수

    override fun play() {
        initGame()
        crossBridge()
    }

    private fun initGame() {
        val bridgeSize = bridgeGameViewMediator.read(inputType = InputType.SIZE).toInt()

        bridge = bridgeMaker.makeBridge(size = bridgeSize)

        bridgeGameViewMediator.write(message = GAME_START_MESSAGE)
    }

    private fun crossBridge() {
        do {
            checkMoving()

            checkCrossingFail()

            checkLastRound()
        } while (position < bridge.size)
    }

    /**
     * 사용자가 움직일 때 상황을 확인한다.
     */
    private fun checkMoving() {
        val moving = bridgeGameViewMediator.read(inputType = InputType.MOVING) // 무빙 입력 받는다.

        val userMoving = if (moving == MOVING_UP_CODE) Moving.UP else Moving.DOWN
        val isCrossed = (moving == bridge[position])
        BridgeCrossingCalculator.updateBridgeCrossingHistory(userMoving = userMoving, isCrossed = isCrossed)

        move()

        bridgeGameViewMediator.write(mapInfo = BridgeCrossingCalculator.getCurrentMap()) // 입력한 무빙에 대해 맵을 출력한다.
    }


    /**
     * 다리를 건너지 못했을 때 상황을 확인한다.
     */
    private fun checkCrossingFail() {
        if (BridgeCrossingCalculator.isCrossingFail()) {
            val command = bridgeGameViewMediator.read(inputType = InputType.COMMAND)
            checkGameCommand(command = command)
        }
    }

    /**
     * 마지막 라운드까지 도달했을 때 상황을 확인한다.
     */
    private fun checkLastRound() {
        if (position == bridge.size) {
            if (!BridgeCrossingCalculator.isCrossingFail()) {
                end()
                return
            }
        }
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
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    override fun move() {
        position++
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    override fun retry() {
        BridgeCrossingCalculator.clearBridgeCrossingHistory()

        numberOfTry++
        position = 0
    }

    /**
     * 게임이 끝났을 때 실행되는 메서드
     */
    override fun end() {
        val gameSuccessResult = BridgeCrossingCalculator.calculateFinalGameResult()

        bridgeGameViewMediator.write(
            mapInfo = BridgeCrossingCalculator.getCurrentMap(),
            gameSuccessResult = gameSuccessResult,
            numberOfTry = numberOfTry
        )
    }
}
