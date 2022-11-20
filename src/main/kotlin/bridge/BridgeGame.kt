package bridge

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
    fun move(readMoving: String, state: String): Array<MutableList<String>> {
        makeMap(readMoving, state)
        when (readMoving) {
            BridgeMaker.UP_STAIR -> {
                bridgeMap[BridgeRandomNumberGenerator.RANDOM_UPPER_INCLUSIVE].add(" ")
            }
            BridgeMaker.DOWN_STAIR -> {
                bridgeMap[BridgeRandomNumberGenerator.RANDOM_LOWER_INCLUSIVE].add(" ")
            }
        }
        return bridgeMap
    }

    private fun makeMap(readMoving: String, state: String) {
        val index = convertIndex(readMoving)
        if (state == readMoving) {
            bridgeMap[index].add(CORRECT_SYMBOL)
            return
        }
        bridgeMap[index].add(NOT_CORRECT_SYMBOL)
    }

    private fun convertIndex(readMoving: String): Int {
        return if (readMoving == BridgeMaker.UP_STAIR) {
            0
        } else {
            1
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(restartCommand: String): Boolean {
        if (restartCommand == RESTART_COMMAND) {
            ++gameCount
            clearMap()
            return true
        }
        return false
    }

    private fun clearMap() {
        with(BridgeRandomNumberGenerator){
            bridgeMap[RANDOM_LOWER_INCLUSIVE].clear()
            bridgeMap[RANDOM_UPPER_INCLUSIVE].clear()
        }
    }


    fun getGameCount(): Int = gameCount

    fun getBridgeMap() = bridgeMap

    companion object {
        private val bridgeMap = Array(2) { mutableListOf<String>() }
        private var gameCount = 1
        const val RESTART_COMMAND = "R"
        const val CORRECT_SYMBOL = "O"
        const val NOT_CORRECT_SYMBOL = "X"
    }
}
