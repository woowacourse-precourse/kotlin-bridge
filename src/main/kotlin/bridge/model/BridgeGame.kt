package bridge.model

import bridge.Constans.INIT_POSITION
import bridge.Constans.O
import bridge.Constans.X
import bridge.Constans.ZERO

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val bridge = Bridge()
    val progressMatrix = ProgressMatrix()

    private var isCorrect = false
    var position = ZERO
    var tryCount = 1

    fun makeBridge(size: Int) {
        bridge.makeBridge(size)
    }

    fun initMatrix(rowCount: Int) {
        progressMatrix.initMatrix(rowCount)
    }

    fun compare(direction: String): Boolean {
        isCorrect = bridge.compare(direction, position)
        return isCorrect
    }

    fun increasePosition() {
        position++
    }

    fun move(direction: String) {
        if (isCorrect) {
            progressMatrix.saveMatrix(direction, O, position)
        } else {
            progressMatrix.saveMatrix(direction, X, position)
        }
    }

    fun retry(size: Int) {
        tryCount++
        position = INIT_POSITION
        progressMatrix.initMatrix(size)
    }

    fun isLastPosition(index: Int): Boolean = position == index
}
