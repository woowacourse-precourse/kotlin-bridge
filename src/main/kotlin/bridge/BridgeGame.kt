package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
// InputView, OutputView 를 사용하지 않는다.

class BridgeGame(private val bridgeLength: Int) {
    private val upBridge = MutableList<String>(bridgeLength) { " " }
    private val downBridge = MutableList<String>(bridgeLength) { " " }
    private var countRetry = 1
    private var progressStatus = true

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge: List<String>, index: Int, move: String) {
        when(bridge[index] == move){
            true -> {
                when(move){
                    "U" -> upBridge[index] = "O"
                    "D" -> downBridge[index] = "O"
                }
            }
            false -> {
                when(move){
                    "U" -> upBridge[index] = "X"
                    "D" -> downBridge[index] = "X"
                }
            }
        }
    }

    fun getUpBridge() = upBridge

    fun getDownBridge() = downBridge

    fun getCountRetry() = countRetry

    fun getProgressStatus() = progressStatus

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        countRetry++
        for (i in 0 until bridgeLength) {
            upBridge[i] = " "
            downBridge[i] = " "
        }
        progressStatus = true
    }
}
