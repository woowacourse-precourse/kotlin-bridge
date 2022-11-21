package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridgeSize: Int) {
    var tryCounter = 1
    var isSuccess = true
    var upperBridge = mutableListOf<String>()
    var downBridge = mutableListOf<String>()

    /*
      사용자가 칸을 이동할 때 사용하는 메서드
      이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge: List<String>, move: String, position: Int) {
        when (bridge[position] == move) {
            true -> {
                when (move) {
                    "U" -> {
                        upperBridge += "O"
                        downBridge += " "
                    }
                    "D" -> {
                        upperBridge += " "
                        downBridge += "O"
                    }
                }
            }
            false -> {
                when (move) {
                    "U" -> {
                        upperBridge += "X"
                        downBridge += " "
                    }
                    "D" -> {
                        upperBridge += " "
                        downBridge += "X"
                    }
                }
                this.isSuccess = false
            }
        }
    }

    /*
      사용자가 게임을 다시 시도할 때 사용하는 메서드
      재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
