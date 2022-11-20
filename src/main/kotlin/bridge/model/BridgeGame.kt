package bridge.model

import bridge.INIT_POSITION
import bridge.O
import bridge.X
import bridge.ZERO

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
