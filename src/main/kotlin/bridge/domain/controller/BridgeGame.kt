package bridge.domain.controller

import bridge.data.InputDataSource
import bridge.data.InputDataSource.bridgeSize
import bridge.data.InputDataSource.initDataSource
import bridge.data.InputDataSource.movingCommands
import bridge.data.InputDataSource.numberOfTry
import bridge.BridgeMaker
import bridge.BridgeMaker.Companion.DOWNSIDE
import bridge.BridgeMaker.Companion.UPSIDE
import bridge.BridgeRandomNumberGenerator
import bridge.ui.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val bridgeMaker: BridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
) {

    fun generateBridge() {
        bridgeMaker.makeBridge(bridgeSize)
//        println(bridgeMaker.makeBridge(InputDataSource.bridgeSize))
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move() {
        when (movingCommands.last()) {
            UPSIDE -> concatMapUpside()
            DOWNSIDE -> concatMapDownside()
            else -> return
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        increaseNumberOfTry()
        initDataSource()
    }


    private fun increaseNumberOfTry() {
        numberOfTry++
    }

    /**
     * @author onseok
     * 위 칸에 대한 다리 상태를 그리는 함수입니다.
     * 아래 칸에 대한 다리 상태는 비워둡니다.
     */
    private fun concatMapUpside() {
        drawUpSideWithState()
        drawDownSideEmpty()
    }

    /**
     * @author onseok
     * 아래 칸에 대한 다리 상태를 그리는 함수입니다.
     * 위 칸에 대한 다리 상태는 비워둡니다.
     */
    private fun concatMapDownside() {
        drawUpSideEmpty()
        drawDownSideWithState()
    }

    private fun drawUpSideWithState() {
        InputDataSource.bridgeMapUp.apply {
            append(OutputView.BRIDGE_HEAD)
            append(currentState())
            append(OutputView.BRIDGE_TAIL)
        }
    }

    private fun drawUpSideEmpty() {
        InputDataSource.bridgeMapUp.apply {
            append(OutputView.BRIDGE_HEAD)
            append(SPACE)
            append(OutputView.BRIDGE_TAIL)
        }
    }

    private fun drawDownSideWithState() {
        InputDataSource.bridgeMapDown.apply {
            append(OutputView.BRIDGE_HEAD)
            append(currentState())
            append(OutputView.BRIDGE_TAIL)
        }
    }

    private fun drawDownSideEmpty() {
        InputDataSource.bridgeMapDown.apply {
            append(OutputView.BRIDGE_HEAD)
            append(SPACE)
            append(OutputView.BRIDGE_TAIL)
        }
    }

    /**
     * @author onseok
     * @return 현재 다리 건너기 게임의 성공, 혹은 실패 여부 상태를 반환
     * @sample O
     * @sample X
     * 현재 입력한 (U, D)의 값과, 해당 인덱스에 대한 다리를 생성할 때 만들어둔 게임 정답값을 비교하여 게임 성공 혹은 실패 여부를 반환하는 함수입니다.
     */
    private fun currentState(): String {
        return if (movingCommands.last() == InputDataSource.bridgeState[movingCommands.size - 1]) SUCCESS else FAILURE
    }

    companion object {
        const val SPACE = " "
        const val SUCCESS = "O"
        const val FAILURE = "X"
    }
}
