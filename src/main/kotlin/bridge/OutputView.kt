package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {}

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    companion object {
        lateinit var errorType: Error
        fun errorMessage() {
            println(errorType.error)
        }
    }

    enum class Error(val error: String) {
        BRIDGE_INPUT_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
        MOVE_INPUT_ERROR("[ERROR] 이동에 대한 입력은 U(위) 혹은 D(아래)만 가능합니다."),
        NON_ERROR("에러 없음"),
    }
}
