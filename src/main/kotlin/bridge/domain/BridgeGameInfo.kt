package bridge.domain

data class BridgeGameInfo(
    var bridge: List<BridgeGameType> = emptyList(),
    var stage: List<Boolean> = mutableListOf(),
    var countOfTry: Int = 0
) {
    fun getUpBridge() = stage
        .mapIndexed { i, status ->
            when {
                bridge[i].type == "U" -> if (status) "O" else "X"
                else -> " "
            }
        }

    fun getDownBridge() = stage
        .mapIndexed { i, status ->
            when {
                bridge[i].type == "D" -> if (status) "O" else "X"
                else -> " "
            }
        }
}
