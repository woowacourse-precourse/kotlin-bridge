package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {
    var upCase: MutableList<String> = mutableListOf<String>()
    var downCase: MutableList<String> = mutableListOf<String>()
    private var index: Int = 0
    private var isSuccess: Boolean = true
    private var totalCount: Int = 1
    private val outputView: OutputView = OutputView()
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun isUpCase(isUp: Boolean) {
        if(isUp) {
            upCase.add("O")
            downCase.add(" ")
        } else {
            upCase.add("X")
            downCase.add(" ")
        }
    }

    fun isDownCase(isDown: Boolean) {
        if(isDown) {
            upCase.add(" ")
            downCase.add("O")
        } else {
            upCase.add(" ")
            downCase.add("X")
        }
    }

    fun move(readMoving: String) {
        when (bridge[index]) {
            "U" -> upMove(readMoving)
            "D" -> downMove(readMoving)
        }
        index += 1
    }

    private fun upMove(readMoving: String) {
        if(readMoving == "U") {
            isUpCase(true)
            isSuccess = true
        } else if(readMoving == "D") {
            isDownCase(false)
            isSuccess = false
        }
    }

    private fun downMove(readMoving: String) {
        if(readMoving == "D") {
            isDownCase(true)
            isSuccess = true
        } else if(readMoving == "U") {
            isUpCase(false)
            isSuccess = false
        }
    }

    fun printResult() {
        outputView.printResult(isSuccess, totalCount)
    }

    fun printMap() {
        outputView.printMap(upCase, downCase)
    }

    fun endGame(): Boolean {
        return isSuccess
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        upCase = mutableListOf<String>()
        downCase = mutableListOf<String>()
        totalCount += 1
        index = 0
        isSuccess = true
    }
}
