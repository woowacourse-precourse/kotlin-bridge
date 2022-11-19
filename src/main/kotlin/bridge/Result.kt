package bridge

class Result {

    var isSuccess: Boolean = false
    var playerResult: ArrayList<Pair<String, Boolean>> = arrayListOf()
    var tryCount: Int = 0

    fun setSuccess() {

    }

    fun addPlayerResult(playerMove: String, isCrossable: Boolean) {
        playerResult.add(playerMove to isCrossable)
    }

    fun increaseTryCount() {

    }
}