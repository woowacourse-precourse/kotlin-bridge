package bridge.model

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val size : Int) {

    private val bridgeMaker : BridgeMaker
    private val bridgeMap: List<String>
    private val comBridge : Bridge
    private var userInputBridge = mutableListOf<String>()
    private var gameCount : Int = 1

    init {
        bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        bridgeMap = bridgeMaker.makeBridge(size)
        comBridge = Bridge(bridgeMap)
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(input : String) : BridgeResult {
        userInputBridge.add(input)
        return comBridge.move(userInputBridge)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(){
        userInputBridge = mutableListOf()
        gameCount++
    }

    fun getGameCount() : Int = gameCount
}
