package bridge

class Result {

    private var isSuccess: Boolean = false
    private var firstRowResult: ArrayList<String> = arrayListOf()
    private var secondRowResult: ArrayList<String> = arrayListOf()
    private var tryCount = 0

    fun getFirstRowResult(): ArrayList<String> {
        return firstRowResult
    }

    fun getSecondRowResult(): ArrayList<String> {
        return secondRowResult
    }

    fun getSuccess(): Boolean {
        return isSuccess
    }

    fun setSuccess() {
        isSuccess = true
    }

    fun addResult(playerMove: String, isCrossable: Boolean) {
        when (playerMove to isCrossable) {
            "U" to true -> {
                firstRowResult.add("O")
                secondRowResult.add(" ")
            }
            "U" to false -> {
                firstRowResult.add("X")
                secondRowResult.add(" ")
            }
            "D" to true -> {
                firstRowResult.add(" ")
                secondRowResult.add("O")
            }
            "D" to false -> {
                firstRowResult.add(" ")
                secondRowResult.add("X")
            }
        }
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