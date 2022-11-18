package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridges: List<String>) {
    private val upSide = mutableListOf<String>()
    private val downSide = mutableListOf<String>()
    private var bridgeIndex = BEGIN_BRIDGE_INDEX
    private var tryCount = BEGIN_TRY_COUNT

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(direction: String) {
        when (direction) {
            bridges[bridgeIndex] -> {
                addSide(direction, Enum.RESULT.SUCCESS.emoji)
                nextBridge()
            }

            else -> addSide(direction, Enum.RESULT.FAILURE.emoji)
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        increaseTry()
        bridgeIndex = BEGIN_BRIDGE_INDEX
        upSide.clear()
        downSide.clear()
    }

    private fun addSide(side: String, result: String) {
        when (side) {
            Enum.SIDE.DOWN.command -> {
                upSide.add(BLANK)
                downSide.add(result)
            }

            Enum.SIDE.UP.command -> {
                upSide.add(result)
                downSide.add(BLANK)
            }
        }
    }

    private fun nextBridge() = bridgeIndex++

    private fun increaseTry() = tryCount++
    fun isFail() = downSide.contains(Enum.RESULT.FAILURE.emoji) || upSide.contains(Enum.RESULT.FAILURE.emoji)

    fun isEnd() = bridgeIndex == bridges.size

    fun getUpSide() = upSide

    fun getDownSide() = downSide

    fun getTryCount() = tryCount

    companion object {
        const val BEGIN_TRY_COUNT = 1
        const val BEGIN_BRIDGE_INDEX = 0
        const val BLANK = " "
    }
}
