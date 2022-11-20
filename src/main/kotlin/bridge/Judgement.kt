package bridge

import java.util.NoSuchElementException

class Judgement {
    private var correctBridgeMap = CorrectBridge

    fun createBridge(size: Int) {
        correctBridgeMap.createBridge(size)
    }

    fun judgeMovingSuccess(currentMoving: List<String>): Boolean {
        return currentMoving.last() == correctBridgeMap.correctBridge[currentMoving.lastIndex]
    }

    fun checkGameOver(currentMoving: List<String>): Boolean {
        var result: Boolean = false
        try {
            if (!judgeMovingSuccess(currentMoving) || currentMoving.lastIndex == correctBridgeMap.correctBridge.size - 1) {
                result = true
            }
        } catch (exception: NoSuchElementException) {
            result = false
        }
        return result
    }

    fun checkGameWin(currentMoving: List<String>): Boolean {
        return judgeMovingSuccess(currentMoving) && currentMoving.lastIndex == correctBridgeMap.correctBridge.size - 1
    }
}