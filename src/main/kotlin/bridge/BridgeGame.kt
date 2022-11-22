package bridge

import kotlin.text.StringBuilder

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

    companion object {
        var upBridge = StringBuilder()
        var downBridge = StringBuilder()
        var previousUpBridge = StringBuilder()
        var previousDownBridge = StringBuilder()
        var bridgeNumber = 0
        var winFlag = "성공"
        var tryNumber = 1
    }

    fun move(userMovingInput: String) {
        if (userMovingInput == "U") {
            if (bridgeNumber == 0) {
                upBridge.append(" O ")
                downBridge.append("   ")
                previousUpBridge.append(" O ")
                previousDownBridge.append("   ")
                bridgeNumber += 1
            }
            else if (bridgeNumber > 0) {
                upBridge.append("| O ")
                downBridge.append("|   ")
                previousUpBridge.append("| O ")
                previousDownBridge.append("|   ")
                bridgeNumber += 1
            }
        }
        else if (userMovingInput == "D") {
            if (bridgeNumber == 0) {
                upBridge.append("   ")
                downBridge.append(" O ")
                previousUpBridge.append("   ")
                previousDownBridge.append(" O ")
                bridgeNumber += 1
            }
            else if (bridgeNumber > 0) {
                upBridge.append("|   ")
                downBridge.append("| O ")
                previousUpBridge.append("|   ")
                previousDownBridge.append("| O ")
                bridgeNumber += 1
            }
        }
    }

    fun moveLose(userMovingInput: String) {
        if (bridgeNumber == 0 && userMovingInput == "U"){ upBridge.append(" X ")
            downBridge.append("   ") }
        else if (bridgeNumber == 0 && userMovingInput == "D"){ upBridge.append("   ")
            downBridge.append(" X ") }
        else if (bridgeNumber > 0 && userMovingInput == "U") { upBridge.append("| X ")
            downBridge.append("|   ") }
        else if (bridgeNumber > 0 && userMovingInput == "D") { upBridge.append("|   ")
            downBridge.append("| X ") }
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
        upBridge = StringBuilder(previousUpBridge)
        downBridge = StringBuilder(previousDownBridge)
        tryNumber += 1
    }
}