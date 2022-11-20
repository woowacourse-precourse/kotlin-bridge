package bridge.domain.game

import bridge.common.*
import bridge.domain.game.service.GameService
import bridge.domain.maker.BridgeMaker
import bridge.domain.moving.MovingInfo
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
    private val bridgeCrossingInfo = mutableListOf<Pair<MovingInfo, Boolean>>()
    private var round = 0 // 다리 건너는 라운드
    private var numberOfTry = 1 // 시도 횟수

    override fun play() {
        // 게임에 필요한 다리 정보 생성 및 게임 시작 문구 출력
        initGame()

        // 사용자 입력 받아서 이동 & 맵 출력
        crossBridge()
    }

    private fun initGame() {
        val bridgeSize = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(size = bridgeSize)

        outputView.printMessage(GAME_START_MESSAGE)
        println(bridge)
    }

    private fun crossBridge() {
        do {
            move()

            // 건너지 못했을 때
            checkCrossingFail()

            // 마지막 라운드까지 모두 다리를 건넜을 때
            checkLastRound()
        } while (round < bridge.size)
    }

    private fun checkCrossingFail() {
        if (isFailCrossing()) {
            // 재시도 여부를 물어본다.
            val command = inputView.readGameCommand()
            checkGameCommand(command = command)
        }
    }

    private fun checkLastRound() {
        if (round == bridge.size) {
            if (!isFailCrossing()) {
                end()
                return
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     */
    private fun move() {
        val moving = inputView.readMoving()
        checkMoving(moving = moving)
        outputView.printMap(bridgeCrossingInfo)
        round++
    }

    private fun checkMoving(moving: String) {
        val userMovingInfo = if (moving == MOVING_UP_CODE) MovingInfo.UP else MovingInfo.DOWN
        val isCrossed = (moving == bridge[round])
        bridgeCrossingInfo.add(userMovingInfo to isCrossed)
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
        bridgeCrossingInfo.clear()

        numberOfTry++
        round = 0
    }

    /**
     * 게임이 끝났을 때 실행되는 메서드
     */
    override fun end() {
        val gameSuccessResult = if (isFailCrossing()) FAIL_MESSAGE else SUCCESS_MESSAGE
        outputView.printResult(bridgeCrossingInfo = bridgeCrossingInfo, gameSuccessResult, numberOfTry)
    }

    private fun isFailCrossing(): Boolean = bridgeCrossingInfo.any { (_, isCrossed) -> !isCrossed }
}
