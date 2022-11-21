package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private lateinit var bridge: Bridge
    private val userStep = mutableListOf<Pair<String, Boolean>>()
    private var retryCount = 1

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun getUserStep() = userStep
    fun getRetryCount() = retryCount

    fun move(step: String) {
        if (!(step == "U" || step == "D"))
            throw IllegalArgumentException("다리를 건널 때는 U나 D만 입력받을수 있습니다.")

        val status = bridge.getCurrentStepStatus(step, userStep.size)

        userStep.add(Pair(step, status))
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        if (retryCount == 1 || userStep.size == 0)
            throw IllegalStateException("재시작은 게임이 진행된 이후 호출 가능합니다.")
        retryCount += 1
        userStep.clear()
    }

    fun hasStepDone() = bridge.getBridgeDone(userStep.size)

    fun hasFailedLastStep() = !userStep.last().second

    fun restart() {
        retryCount = 1
        userStep.clear()
    }

    fun makeBridge(size: Int) {
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridgeSteps = bridgeMaker.makeBridge(size)
        bridge = Bridge(bridgeSteps)
    }

    fun makeBridge(bridge: Bridge) {
        this.bridge = bridge
    }

}
