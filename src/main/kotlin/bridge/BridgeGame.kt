package bridge

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

    val userMovingResult = mutableListOf<Pair<String,Boolean>>()
    var presentPosition = INITIALIZE_TO_ZERO
    var gameTryCount = INITIALIZE_TO_ZERO

    fun move(userChoice:String, bridge: Bridge): GameResult {
        if(bridge.matchUserChoice(userChoice,presentPosition)) {
            userMovingResult.add(Pair(userChoice,true))
            presentPosition++
            return GameResult.SUCCESS
        }
        userMovingResult.add(Pair(userChoice,false))
        return GameResult.FAILURE
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        presentPosition = INITIALIZE_TO_ZERO
        userMovingResult.clear()
        gameTryCount ++
    }

    enum class GameResult{
        SUCCESS,
        FAILURE
    }

    companion object {
        const val INITIALIZE_TO_ZERO = 0
    }
}
