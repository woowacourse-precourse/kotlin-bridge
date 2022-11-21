package bridge.domain

data class BridgeGameInfo(
    var bridge: List<BridgeGameType> = emptyList(),
    var stage: List<Boolean> = mutableListOf(),
    var countOfTry: Int = 0
) {
    fun getBridge(bridgeGameType: BridgeGameType) = stage
        .mapIndexed { i, status ->
            when (bridge[i].type) {
                bridgeGameType.type -> if (status) "O" else "X"
                else -> " "
            }
        }
}
