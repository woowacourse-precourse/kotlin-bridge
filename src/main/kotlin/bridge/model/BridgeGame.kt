package bridge.model

import bridge.O
import bridge.X

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val bridge = Bridge()
    val progressMatrix = ProgressMatrix()
    private var isCorrect = false

    fun makeBridge(size: Int) {
        bridge.makeBridge(size)
    }

    fun initMatrix(rowCount: Int) {
        progressMatrix.initMatrix(rowCount)
    }

    fun compare(direction: String, position: Int): Boolean {
        isCorrect = bridge.compare(direction, position)
        return isCorrect
    }

    fun move(direction: String, position: Int) {
        if (isCorrect) {
            progressMatrix.saveMatrix(direction, O, position)
        } else {
            progressMatrix.saveMatrix(direction, X, position)
        }
    }

    fun retry() {}
}
