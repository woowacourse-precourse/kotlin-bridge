package bridge

import camp.nextstep.edu.missionutils.Console


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val size : Int) {

    private var gameCount : Int = 1
    private var idx : Int = 0
    private var bridgeMaker : BridgeMaker
    private var bridgeMap: List<String>
    private var bridge : Bridge

    init {
        bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        bridgeMap = bridgeMaker.makeBridge(size)
        bridge = Bridge(size)
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(input : String) {
        bridge.move(BridgeDirection.valueOf(input), bridgeMap, idx)
        idx++
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(){
        gameCount++
        idx = 0
        bridge = Bridge(size)
    }

    fun getGameResult() : Boolean {
        if(size == bridge.getGameResult()) return true
        return false
    }

    fun getInputMovePossible(input: String) : Boolean {
        if(bridge.movePossible(BridgeDirection.valueOf(input), bridgeMap, idx)) return true
        return false
    }

    fun getBridge() : Bridge = bridge

    fun getGameCount() : Int = gameCount
}
