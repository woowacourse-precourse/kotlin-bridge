package bridge.model

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val bridge = Bridge()
    private val progressMatrix = ProgressMatrix()

    fun makeBridge(size: Int) {
        bridge.makeBridge(size)
    }

    fun initMatrix(rowCount: Int) {
        progressMatrix.initMatrix(rowCount)
    }

    fun compare(direction: String, position: Int) {
        bridge.compare(direction, position)
    }

    fun move() {}

    fun retry() {}
}
