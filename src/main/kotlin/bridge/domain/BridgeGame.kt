package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.resources.BRIDGE_RETRY
import bridge.view.InputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(nextPosition: String, userSelectedRoute: MutableList<String>) {
        userSelectedRoute.add(nextPosition)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(): Boolean = InputView().readGameCommand() == BRIDGE_RETRY
    fun getBridge(bridgeLength: Int): List<String> = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    fun isCurrentPositionCorrect(correctRoute: List<String>, userSelectedRoute: List<String>) : Boolean =
        correctRoute[userSelectedRoute.lastIndex] == userSelectedRoute.last()
}
