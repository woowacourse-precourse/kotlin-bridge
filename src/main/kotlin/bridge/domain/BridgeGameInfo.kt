package bridge.domain

data class BridgeGameInfo(
    var bridge: List<String> = emptyList(),
    var stage: List<Boolean> = mutableListOf(),
    var countOfTry: Int = 0
)