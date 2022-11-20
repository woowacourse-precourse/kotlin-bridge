package bridge.domain.game

import bridge.common.GAME_START_MESSAGE
import bridge.common.MOVING_UP_CODE
import bridge.domain.maker.BridgeMaker
import bridge.domain.moving.MOVING
import bridge.ui.view.InputView
import bridge.ui.view.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val bridgeMaker: BridgeMaker
) {
    private lateinit var bridge: List<String>
    private val bridgeCrossingInfo = mutableListOf<Pair<MOVING, Boolean>>()

    private var round = 0 // 다리 건너는 라운드
    private var numberOfTry = 0 // 시도 횟수

    fun play() {
        outputView.printMessage(GAME_START_MESSAGE)

        val bridgeSize = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(size = bridgeSize)
        println(bridge)

        // 사용자 입력 받아서 이동 & 맵 출력
        do {
            val moving = inputView.readMoving()
            move(moving)

//            if (bridgeCrossingInfo.contains(false)) {
//                // retry
//                bridgeCrossingInfo.clear()
//                userMovingInfo.clear()
//                numberOfTry++
//                round = 0
//                break
//            }

        } while (round < bridge.size)

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun move(moving: String) {
        checkMoving(moving = moving)
        outputView.printMap(bridgeCrossingInfo)
        round++
    }

    private fun checkMoving(moving: String) {
        val userMoving = if (moving == MOVING_UP_CODE) MOVING.UP else MOVING.DOWN
        val isCrossed = moving == bridge[round]
        bridgeCrossingInfo.add(userMoving to isCrossed)
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
