package bridge.model

import bridge.model.Bridge
import bridge.utils.Constants.SUCCESS_SYMBOL
import bridge.utils.Constants.FAIL_SYMBOL
import bridge.utils.Constants.UP_SYMBOL
import bridge.utils.Constants.DOWN_SYMBOL

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    val upLane = mutableListOf<Char>()
    val downLane = mutableListOf<Char>()
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(inputMoveLaneSymbol: Char, bridge: Bridge) {
        when (bridge.getWhichLaneAvailableMessage(inputMoveLaneSymbol)){
            "upLaneSuccess" -> addEachLaneWhenUpLaneSuccess()
            "downLaneSuccess" -> addEachLaneWhenDownLaneSuccess()
        }
    }

    fun addEachLaneWhenUpLaneSuccess(){
        upLane.add(UP_SYMBOL)
        downLane.add(' ')
    }

    fun addEachLaneWhenDownLaneSuccess(){
        upLane.add(' ')
        downLane.add(DOWN_SYMBOL)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
