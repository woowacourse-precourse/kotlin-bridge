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
            "U" to true -> addResultEachRow(first = "O", second = " ")
            "U" to false -> addResultEachRow(first = "X", second = " ")
            "D" to true -> addResultEachRow(first = " ", second = "O")
            "D" to false -> addResultEachRow(first = " ", second = "X")
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
}