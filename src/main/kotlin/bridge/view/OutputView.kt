package bridge.view

import bridge.MovingEventListener
import bridge.QuitEventListener
import bridge.model.GameResult
import bridge.model.GameMapStatus

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView : MovingEventListener, QuitEventListener {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun printMap(map: GameMap) = println(map)

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun printResult(map: GameMap, result: GameResult) {
        println(FINAL_GAME_RESULT_SUBJECT)
        printMap(map)
        println(GAME_SUCCESS_FIELD + if (result.success) SUCCESS else FAILED)
        println(ATTEMPTS_FIELD + result.attempts)
    }

    override fun update(gameMapStatus: GameMapStatus) = printMap(GameMap(gameMapStatus))

    override fun update(gameMapStatus: GameMapStatus, gameResult: GameResult) =
        printResult(GameMap(gameMapStatus), gameResult)

    companion object {
        private const val FINAL_GAME_RESULT_SUBJECT = "최종 게임 결과"
        private const val GAME_SUCCESS_FIELD = "게임 성공 여부: "
        private const val ATTEMPTS_FIELD = "총 시도한 횟수: "
        private const val SUCCESS = "성공"
        private const val FAILED = "실패"
    }
}
