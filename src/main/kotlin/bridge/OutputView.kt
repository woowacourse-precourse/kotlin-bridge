package bridge

const val START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다. \n"
const val INPUT_LENGTH_MESSAGE ="다리의 길이를 입력해주세요."
const val INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val INPUT_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
class OutputView {
    fun printStartGame(){
        println(START_GAME_MESSAGE)
    }
    fun printInputLength(){
        println(INPUT_LENGTH_MESSAGE)
    }
    fun printInputMove(){
        println(INPUT_MOVE_MESSAGE)
    }
    fun printInputGameCommand(){
        println(INPUT_COMMAND_MESSAGE)
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(upBridge: String,downBridge: String) {
        println("[$upBridge]")
        println("[$downBridge]")
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
