package bridge.domain.game

import bridge.common.GAME_START_MESSAGE
import bridge.domain.maker.BridgeMaker
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
    private lateinit var bridgeCrossingInfo: MutableList<Boolean>
    private val userMovingInfo = mutableListOf<String>()
    private var round = 1
    private var numberOfTry = 0

    fun play() {
        outputView.printMessage(GAME_START_MESSAGE)

        val bridgeSize = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(size = bridgeSize)
        bridgeCrossingInfo = MutableList(bridge.size) { false }

        do {
            val moving = inputView.readMoving()
            userMovingInfo.add(moving)
            move(moving)
        } while (true)
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(moving: String) {
        checkMoving(moving = moving)
        outputView.printMap(bridgeCrossingInfo.take(round), userMovingInfo)
        round++
    }

    private fun checkMoving(moving: String) {
        bridgeCrossingInfo[round - 1] = moving == bridge[round - 1]
    }



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
