package bridge

class Result {

    var isSuccess: Boolean = false
    var firstRowResult: ArrayList<String> = arrayListOf()
    var secondRowResult: ArrayList<String> = arrayListOf()
    var tryCount: Int = 0

    fun setSuccess() {

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

    fun increaseTryCount() {

    }
}