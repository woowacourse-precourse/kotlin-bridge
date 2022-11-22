package bridge.ui

import bridge.domain.controller.BridgeGame
import bridge.data.GameResult
import bridge.data.InputError
import bridge.data.InputDataSource
import bridge.data.InputDataSource.bridgeMapDown
import bridge.data.InputDataSource.bridgeMapUp
import bridge.data.InputDataSource.numberOfTry

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView(
    private val bridgeGame: BridgeGame = BridgeGame(),
) {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {
        bridgeGame.move()
        printCurMap()
    }

    private fun printCurMap() {
        println(bridgeMapUp.toString().replace(BRIDGE_PACKED, BRIDGE_SCREEN))
        println(bridgeMapDown.toString().replace(BRIDGE_PACKED, BRIDGE_SCREEN))
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(gameResult: GameResult) {
        println(PRINT_GAME_RESULT)
        printCurMap()
        println(PRINT_GAME_SUCCESS_OR_NOT + printSuccessOrFailure(gameResult))
        println(PRINT_TOTAL_RETRY_COUNT + numberOfTry)
    }

    fun printError(inputError: InputError) {
        print(ERROR)
        when (inputError) {
            is InputError.BridgeSizeInputError -> println(inputError.errorMessage)
            is InputError.MovingInputError -> println(inputError.errorMessage)
            is InputError.GameCommandInputError -> println(inputError.errorMessage)
        }
    }

    private fun printSuccessOrFailure(gameResult: GameResult): String {
        return when (gameResult) {
            is GameResult.Success -> SUCCESS
            is GameResult.Failure -> FAILURE
        }
    }

    companion object {
        const val PRINT_START_GAME = "다리 건너기 게임을 시작합니다.\n"
        const val PRINT_GAME_RESULT = "최종 게임 결과"
        const val PRINT_GAME_SUCCESS_OR_NOT = "게임 성공 여부: "
        const val PRINT_TOTAL_RETRY_COUNT = "총 시도한 횟수: "

        const val SUCCESS = "성공"
        const val FAILURE = "실패"

        const val BRIDGE_HEAD = "[ "
        const val BRIDGE_TAIL = " ]"
        const val BRIDGE_SCREEN = "|"
        const val BRIDGE_PACKED = "]["

        const val ERROR = "[ERROR] "
    }
}
