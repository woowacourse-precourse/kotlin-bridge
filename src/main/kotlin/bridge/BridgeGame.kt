package bridge

import bridge.model.Bridge
import bridge.model.BridgeStatus
import bridge.model.BridgeResult

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    private val bridgeResult = BridgeResult()
    private lateinit var bridgeStatus: BridgeStatus
    private lateinit var bridgeMaker: BridgeMaker
    private lateinit var bridge: Bridge
    private var position: Int = 0

    fun initGame(size: Int, maker: BridgeMaker) {
        bridgeMaker = maker
        bridge = generateRandomBridge(size)
    }

    private fun generateRandomBridge(size: Int) = Bridge(bridgeMaker.makeBridge(size))

    fun getTotalCount(): Int = bridgeResult.getTotalCount()
    private fun resetPosition() {
        position = 0
        bridgeResult.restart()
    }

    fun getBridgeMap() = bridgeResult.getBridgeMap()

    fun updateMap(result: BridgeStatus) {
        bridgeStatus = result
        bridgeResult.update(bridgeStatus)
    }

    fun finish(result: BridgeStatus) {
        bridgeStatus = BridgeStatus.FINISH(result.getDirection())
    }

    fun isEnded() = bridgeStatus is BridgeStatus.FINISH


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param direction 위(U), 아래(D) 건너는 위치
     * @return enum class인 BridgeResult를 반환한다.
     */
    fun move(direction: String): BridgeStatus {
        return bridge.move(position++, direction)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param userChoice 재시도(R) 종료(Q), 재시도 여부
     * @return 재시도를 하는지에 대한 유무
     */
    fun retry(userChoice: String): Boolean {
        require(userChoice == "R" || userChoice == "Q")
        if (userChoice == "R") {
            resetPosition()
            return true
        }
        return false
    }


}
