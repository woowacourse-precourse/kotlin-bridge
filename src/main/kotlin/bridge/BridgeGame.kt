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

    fun move(bridgeAns: String, userMovingInput: String) {
        if (bridgeAns == "U" && userMovingInput == "U") {
            upBridge += " O "
            upBridge += "|"
        }
        else if (bridgeAns == "D" &&userMovingInput == "D") {
            downBridge += " O "
            downBridge += "|"
        }
        else if (bridgeAns == "U" && userMovingInput == "D"){
            downBridge += " X ]"
        }
        else {
            upBridge += " X ]"
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
