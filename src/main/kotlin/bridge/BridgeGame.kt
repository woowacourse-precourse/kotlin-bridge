package bridge

import constant.Message
import constant.Symbol

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(val bridge: List<String>) {

    private val up = mutableListOf<String>()
    private val down = mutableListOf<String>()

    init {
        move()
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun move() {
        for (i in bridge.indices) {
            val success = calcResult()
            OutputView().printMap(up, down)
            if (!success) {
                checkRetry()
                break
            }
        }
    }

    private fun calcResult(): Boolean {
        val moving = InputView().readMoving()
        if (moving == Symbol.UP.symbol) {
            return calcUpResult(moving)
        }
        return calcDownResult(moving)
    }

    private fun calcUpResult(moving: String): Boolean {
        down.add(Symbol.NOTHING.symbol)
        if (bridge[up.size] == moving) {
            up.add(Symbol.SUCCESS.symbol)
            return true
        }
        up.add(Symbol.FAIL.symbol)
        return false
    }

    private fun calcDownResult(moving: String): Boolean {
        up.add(Symbol.NOTHING.symbol)
        if (bridge[down.size] == moving) {
            down.add(Symbol.SUCCESS.symbol)
            return true
        }
        down.add(Symbol.FAIL.symbol)
        return false
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun retry() {
        up.clear()
        down.clear()
        move()
    }

    private fun checkRetry() {
        val retry = InputView().readGameCommand()
        if (retry == Symbol.RETRY.symbol) retry()
    }
}
