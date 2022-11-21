package bridge

import constant.Message

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
        var attempt = 0
        for (i in bridge.indices) {
            val success = calcResult()
            attempt++
            if (!success) {
                break
            }
        }
    }

    private fun calcResult(): Boolean {
        val moving = InputView().readMoving()
        if (moving == "U") {
            return calcUpResult(moving)
        }
        return calcDownResult(moving)
    }

    private fun calcUpResult(moving: String): Boolean {
        down.add(Message.NOTHING.message)
        if (bridge[up.size] == moving) {
            up.add(Message.SUCCESS.message)
            return true
        }
        up.add(Message.FAIL.message)
        return false
    }

    private fun calcDownResult(moving: String): Boolean {
        up.add(Message.NOTHING.message)
        if (bridge[down.size] == moving) {
            down.add(Message.SUCCESS.message)
            return true
        }
        down.add(Message.FAIL.message)
        return false
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
