package bridge.view

import bridge.MovingEventListener
import bridge.QuitEventListener
import bridge.model.GameResult
import bridge.model.GameMapStatus

class OutputView : MovingEventListener, QuitEventListener {
    private fun printMap(map: GameMap) = println(map)

    private fun printResult(map: GameMap, result: GameResult) {
        println(FINAL_GAME_RESULT_SUBJECT)
        printMap(map)
        println(GAME_RESULT_FIELD + if (result.success) SUCCESS else FAILED)
        println(ATTEMPTS_FIELD + result.attempts)
    }

    override fun update(gameMapStatus: GameMapStatus) = printMap(GameMap(gameMapStatus))

    override fun update(gameMapStatus: GameMapStatus, gameResult: GameResult) =
        printResult(GameMap(gameMapStatus), gameResult)

    companion object {
        private const val FINAL_GAME_RESULT_SUBJECT = "최종 게임 결과"
        private const val GAME_RESULT_FIELD = "게임 성공 여부: "
        private const val ATTEMPTS_FIELD = "총 시도한 횟수: "
        private const val SUCCESS = "성공"
        private const val FAILED = "실패"
    }
}
