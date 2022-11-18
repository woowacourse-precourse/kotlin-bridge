package bridge

import bridge.resources.*
import bridge.view.InputView
import bridge.view.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(val bridge: List<String>, private val retry: Int) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(location: Int) {
        val answer = bridge[location] == inputMove()
        OutputView().printMap(bridge, location, answer)
        if (location < bridge.size - 1 && answer) move(location + NEXT_MOVE) // 범위 안에서 재귀
        if (location == bridge.size - 1 && answer) { // 끝까지 건넜을 때
            OutputView().printResult(bridge, location, true)
            OutputView().printEnd(true, this.retry)
        }
        if (!answer) retry(location)
    }

    private fun inputMove() = InputView().readMoving()

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(location: Int) {
        val retryCheck = InputView().readGameCommand()
        if (retryCheck == RETRY) BridgeGame(this.bridge, this.retry + NEXT_TRY).move(START_LOCATION)
        if (retryCheck == QUIT) {
            OutputView().printResult(bridge, location, false)
            OutputView().printEnd(false, this.retry)
        }
    }
}
