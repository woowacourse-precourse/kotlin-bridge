package bridge

class OutputView {
    fun printMap(bridgeGame: BridgeGame) {
        println("[ " + bridgeGame.resultUpBridge.joinToString(" | ") + " ]")
        println("[ " + bridgeGame.resultDownBridge.joinToString(" | ") + " ]")
    }

    fun printResult(bridgeGame: BridgeGame) {
        println("최종 게임 결과")
        printMap(bridgeGame)
        print("\n게임 성공 여부: ")
        if (bridgeGame.check() && bridgeGame.over()) {
            println("성공")
        }
        else {
            println("실패")
        }
        println("총 시도한 횟수: " + bridgeGame.playCount)
    }

    fun printStart() = println(GAME_START_MESSAGE + "\n\n" + REQUEST_INPUT_MESSAGE)
    fun printRestart() = println("\n" + REQUEST_RESTART_MESSAGE)
    fun printUpOrDown() = println("\n" + UP_OR_DOWN_MESSAGE)
    fun printSizeInputError() = println(ERROR + WRONG_SIZE_INPUT_MESSAGE)
    fun printSizeRangeError() = println(ERROR + WRONG_SIZE_RANGE_MESSAGE)
    fun printMovingInputError() = println(ERROR + WRONG_MOVING_INPUT_MESSAGE)
    fun printCommandInputError() = println(ERROR + WRONG_COMMAND_INPUT_MESSAGE)

    companion object {
        private const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
        private const val REQUEST_INPUT_MESSAGE = "다리의 길이를 입력해주세요."
        private const val UP_OR_DOWN_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        private const val REQUEST_RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        private const val ERROR = "[ERROR] "
        private const val WRONG_SIZE_INPUT_MESSAGE = "다리의 길이는 숫자만 입력 가능합니다."
        private const val WRONG_SIZE_RANGE_MESSAGE = "다리의 길이는 3과 20 사이의 숫자만 가능합니다."
        private const val WRONG_MOVING_INPUT_MESSAGE = "움직이는 명령어는 U:위, D:아래 만 입력 가능합니다."
        private const val WRONG_COMMAND_INPUT_MESSAGE = "게임 재시작 명령어는 R:재시작, Q:게임종료 만 입력 가능합니다."
    }
}
