package bridge.domain

data class User(
    val movingResults: MutableList<Pair<String, Boolean>> = mutableListOf<Pair<String, Boolean>>(),
    var moving: String = "",
    var presentPosition: Int = INITIALIZE_TO_START,
    var tryCount: Int = INITIALIZE_TO_ONE,
) {

    companion object {
        const val INITIALIZE_TO_START = -1
        const val INITIALIZE_TO_ONE = 1
    }
}
