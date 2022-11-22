package bridge.model

import bridge.utils.Constants.UP_SYMBOL
import bridge.utils.Constants.DOWN_SYMBOL
import bridge.utils.Constants.EMPTY_SYMBOL
import bridge.utils.Constants.SUCCESS_SYMBOL
import bridge.utils.Constants.FAIL_SYMBOL

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    var upLane = mutableListOf<String>()
    var downLane = mutableListOf<String>()
    var isMovingSuccess = true
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(inputMoveLaneSymbol: String, bridge: Bridge){
        when (bridge.isLaneAvailable(inputMoveLaneSymbol)){
            true -> addWhenLaneAvailable(inputMoveLaneSymbol)
            false -> {
                addWhenLaneNotAvailable(inputMoveLaneSymbol)
                isMovingSuccess = false
            }
        }
    }

    /**
     * 이동 가능한 칸일 때 O 추가
     */
    private fun addWhenLaneAvailable(inputMoveLaneSymbol: String){
        when (inputMoveLaneSymbol){
            UP_SYMBOL -> addUpLaneSuccessSymbol()
            DOWN_SYMBOL -> addDownLaneSuccessSymbol()
        }
    }

    /**
     * 다리 위칸에 O, 아래칸에 공백 추가
     */
    private fun addUpLaneSuccessSymbol(){
        upLane.add(SUCCESS_SYMBOL)
        downLane.add(EMPTY_SYMBOL)
    }

    /**
     * 다리 아래칸에 O, 위칸에 공백 추가
     */
    private fun addDownLaneSuccessSymbol(){
        upLane.add(EMPTY_SYMBOL)
        downLane.add(SUCCESS_SYMBOL)
    }

    /**
     * 이동 불가능한 칸일 때 X 를 추가
     */
    private fun addWhenLaneNotAvailable(inputMoveLaneSymbol: String){
        when (inputMoveLaneSymbol){
            UP_SYMBOL -> addUpLaneFailSymbol()
            DOWN_SYMBOL -> addDownLaneFailSymbol()
        }
    }

    /**
     * 다리 위칸에 X, 아래칸에 공백 추가
     */
    private fun addUpLaneFailSymbol(){
        upLane.add(FAIL_SYMBOL)
        downLane.add(EMPTY_SYMBOL)
    }

    /**
     * 다리 아래칸에 X, 위칸에 공백 추가
     */
    private fun addDownLaneFailSymbol(){
        upLane.add(EMPTY_SYMBOL)
        downLane.add(FAIL_SYMBOL)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        laneValueInitialize()
    }

    /**
     * 변수들을 초기화 해주는 함수
     */
    fun laneValueInitialize(){
        upLane = mutableListOf()
        downLane = mutableListOf()
        isMovingSuccess = true
    }
}
