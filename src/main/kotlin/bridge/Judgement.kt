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
        try {
            if (!judgeMovingSuccess(currentMoving) || currentMoving.lastIndex == correctBridgeMap.correctBridge.size - 1) {
                return true
            }
        } catch (exception: NoSuchElementException) {
            return false
        }
        return false
    }

    fun checkGameWin(currentMoving: List<String>): Boolean {
        return judgeMovingSuccess(currentMoving) && currentMoving.lastIndex == correctBridgeMap.correctBridge.size - 1
    }
}