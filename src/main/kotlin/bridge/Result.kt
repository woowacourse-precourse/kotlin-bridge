package bridge

import java.util.*
import kotlin.collections.ArrayList

class Result {

    private var isSuccess: Boolean = false
    private var firstRowResult: ArrayList<String> = arrayListOf()
    private var secondRowResult: ArrayList<String> = arrayListOf()
    private var tryCount = 0

    fun getFirstRowResult(): MutableList<String> {
        return Collections.unmodifiableList(firstRowResult)
    }

    fun getSecondRowResult(): MutableList<String> {
        return Collections.unmodifiableList(secondRowResult)
    }

    fun getSuccess(): Boolean {
        return isSuccess
    }

    fun setSuccess() {
        isSuccess = true
    }

    fun addResult(playerMove: String, isCrossable: Boolean) {
        when (playerMove to isCrossable) {
            GameCommand.UP.getCommand() to true -> addResultEachRow(first = CORRECT, second = EMPTY)
            GameCommand.UP.getCommand() to false -> addResultEachRow(first = WRONG, second = EMPTY)
            GameCommand.DOWN.getCommand() to true -> addResultEachRow(first = EMPTY, second = CORRECT)
            GameCommand.DOWN.getCommand() to false -> addResultEachRow(first = EMPTY, second = WRONG)
        }
    }

    private fun addResultEachRow(first: String, second: String) {
        firstRowResult.add(first)
        secondRowResult.add(second)
    }

    fun resetResult() {
        firstRowResult.clear()
        firstRowResult = arrayListOf()
        secondRowResult.clear()
        secondRowResult = arrayListOf()
        isSuccess = false
    }

    fun getTryCount(): Int {
        return tryCount
    }

    fun increaseTryCount() {
        tryCount++
    }

    companion object {
        const val CORRECT = "O"
        const val WRONG = "X"
        const val EMPTY = " "
    }
}