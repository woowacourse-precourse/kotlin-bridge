package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printGameStart() = println(GAME_START_MESSAGE)
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(curBridge: Pair<String,String>) {
        println(curBridge.first)
        println(curBridge.second)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(curBridge: Pair<String,String>, bridgeGame: BridgeGame) {
        println(GAME_RESULT_MESSAGE)
        printMap(curBridge)
        println(GAME_SUCCESS_MESSAGE + SuccessMessage.values()[bridgeGame.isFailed().compareTo
            (false)].message)
        println(GAME_TRY_MESSAGE + bridgeGame.getRound() )
    }

    companion object {
        private const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
        private const val GAME_RESULT_MESSAGE = "최종 게임 결과"
        private const val GAME_SUCCESS_MESSAGE = "게임 성공 여부: "
        private const val GAME_TRY_MESSAGE = "총 시도한 횟수: "
    }

    enum class SuccessMessage( val message: String) {
        SUCCESS("성공"),
        FAIL("실패")
    }
}
