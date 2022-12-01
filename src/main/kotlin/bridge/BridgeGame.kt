package bridge

import util.Constant
import util.Result
import util.Side

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridges: List<String>) {
    private val upSide = mutableListOf<String>()
    private val downSide = mutableListOf<String>()
    private var bridgePosition = Constant.INIT_BRIDGE_POSITION
    private var retryCount = Constant.INIT_RETRY_COUNT

    fun move(direction: String) {
        when (direction) {
            bridges[bridgePosition] -> {
                checkSide(direction, Result.SUCCESS.emoji)
                bridgePosition++
            }

            else -> checkSide(direction, Result.FAILURE.emoji)
        }
    }

    private fun checkSide(side: String, result: String) {
        when (side) {
            Side.DOWN.command -> addDownSide(result)

            Side.UP.command -> addUpSide(result)
        }
    }

    private fun addUpSide(result: String) {
        upSide.add(result)
        downSide.add(Constant.BLANK)
    }

    private fun addDownSide(result: String) {
        upSide.add(Constant.BLANK)
        downSide.add(result)
    }

    fun retry() {
        increaseTryCount()
        bridgePosition = Constant.INIT_BRIDGE_POSITION
        upSide.clear()
        downSide.clear()
    }

    private fun increaseTryCount() = retryCount++

    fun isFail() = downSide.contains(Result.FAILURE.emoji) || upSide.contains(Result.FAILURE.emoji)

    fun isEnd() = bridgePosition == bridges.size

    fun getMap() = listOf(changeUpSideFormat(), changeDownSideFormat())

    private fun changeUpSideFormat() = upSide.joinToString(" | ", "[ ", " ]")

    private fun changeDownSideFormat() = downSide.joinToString(" | ", "[ ", " ]\n")

    fun getRetryCount() = retryCount
}
