package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    var upBridge = "["
    var downBridge = "["
    var tryNumber = 0
    var winFlag = "성공"
    var finishFlag = false

    fun move(bridgeAns: String, userMovingInput: String) {
        if (bridgeAns == "U" && userMovingInput == "U") {
            upBridge += " O |"
            tryNumber += 1
        }
        else if (bridgeAns == "D" &&userMovingInput == "D") {
            downBridge += " O |"
            tryNumber += 1
        }
        else if (bridgeAns == "U" && userMovingInput == "D"){
            downBridge += " X ]"
            tryNumber += 1
        }
        else {
            upBridge += " X ]"
            tryNumber += 1
        }
    }

    fun finishBridge() {
        upBridge += "]"
        downBridge += "]"
    }

    fun checkFinishGame(bridgeSize: Int) {
        val checkUsedBridge = upBridge.count{ it == 'O' } + downBridge.count{ it == 'O' }
        if (bridgeSize == checkUsedBridge || 'X' in upBridge || 'X' in downBridge) {
            finishFlag = true
        }
    }

    fun checkWinLose() {
        if ("X" in upBridge || "X" in downBridge) {
            winFlag = "실패"
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        // 이전 상태로 되돌려주는 메서드
        if ("| X ]" in upBridge) upBridge.replace("| X", "")
        if ("| X ]" in downBridge) downBridge.replace("| X", "")
    }
}
