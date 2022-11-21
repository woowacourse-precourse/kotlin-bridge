package bridge

import bridge.util.BridgeMoving

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    val userMovingResults = mutableListOf<Pair<String, Boolean>>()
    var userMovingLocation = ""
    var userPresentPosition = INITIALIZE_TO_ZERO
    var gameTryCount = INITIALIZE_TO_ONE

    fun move(moving: String){
        userMovingLocation = moving
        userPresentPosition++
    }

    fun getGameResult(bridge:Bridge):GameResult{
        if(bridge.isMatchMoving(userMovingLocation,userPresentPosition)) {
            userMovingResults.add(Pair(userMovingLocation,true))
            if(userPresentPosition == bridge.length()-1) return GameResult.SUCCESS
            userPresentPosition ++
            return GameResult.CONTINUE
        }
        userMovingResults.add(Pair(userMovingLocation,false))
        return GameResult.FAILURE
    }

    fun getMap(movingMatchResults: List<Pair<String, Boolean>>): String {
        return getUpperMap(movingMatchResults) + "\n" + getLowerMap(movingMatchResults)
    }

    fun getUpperMap(movingMatchResults: List<Pair<String, Boolean>>): String {
        var result = START_BRIDGE
        movingMatchResults.forEachIndexed { index, movingMatchResult ->
            result = result.plus(getStepResult(movingMatchResult, BridgeMoving.UP.character))
            if (index != movingMatchResults.size - 1) result = result.plus(DIVIDING_LINE)
        }
        return result.plus(END_BRIDGE)
    }

    fun getLowerMap(movingMatchResults: List<Pair<String, Boolean>>): String {
        var result = START_BRIDGE
        movingMatchResults.forEachIndexed { index, movingMatchResult ->
            result = result.plus(getStepResult(movingMatchResult, BridgeMoving.DOWN.character))
            if (index != movingMatchResults.size - 1) result = result.plus("|")
        }
        return result.plus(END_BRIDGE)
    }

    fun getStepResult(movingMatchResult: Pair<String, Boolean>, bridgeLocation: String): String {
        val moving = movingMatchResult.first
        val isCrossable = movingMatchResult.second
        if (moving == bridgeLocation && isCrossable) return (CROSSABLE_BRIDGE)
        if (moving == bridgeLocation && !isCrossable) return (NON_CROSSABLE_BRIDGE)
        return UN_CHOSEN_BRIDGE
    }

    fun getGameResultMessage(gameResult: GameResult): String {
        if (gameResult == GameResult.SUCCESS) return GAME_SUCCESS_MESSAGE
        if (gameResult == GameResult.FAILURE) return GAME_FAILURE_MESSAGE
        return ERROR
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        userPresentPosition = INITIALIZE_TO_ZERO
        userMovingResults.clear()
        gameTryCount++
    }

    enum class GameResult {
        SUCCESS,
        CONTINUE,
        FAILURE
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val START_BRIDGE = "["
        const val END_BRIDGE = "]"
        const val CROSSABLE_BRIDGE = " O "
        const val NON_CROSSABLE_BRIDGE = " X "
        const val UN_CHOSEN_BRIDGE = "   "
        const val DIVIDING_LINE = "|"
        const val INITIALIZE_TO_ZERO = 0
        const val INITIALIZE_TO_ONE = 1
        const val GAME_SUCCESS_MESSAGE = "성공"
        const val GAME_FAILURE_MESSAGE = "실패"
    }
}
