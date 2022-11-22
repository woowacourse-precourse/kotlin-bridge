package bridge

class BridgeGame(private val bridge: List<String>) {
    var upCase: MutableList<String> = mutableListOf<String>()
    var downCase: MutableList<String> = mutableListOf<String>()
    private var index: Int = 0
    private var isSuccess: Boolean = true
    var totalCount: Int = 1
    private val outputView: OutputView = OutputView()

    private fun isUpCase(isUp: Boolean) {
        if(isUp) {
            upCase.add("O")
            downCase.add(" ")
        } else {
            upCase.add("X")
            downCase.add(" ")
        }
    }

    private fun isDownCase(isDown: Boolean) {
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

    fun retry() {
        upCase = mutableListOf<String>()
        downCase = mutableListOf<String>()
        totalCount += 1
        index = 0
        isSuccess = true
    }
}
