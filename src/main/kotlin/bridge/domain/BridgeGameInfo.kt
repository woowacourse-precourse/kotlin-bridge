package bridge.domain

import bridge.resources.PLATE_BLANK
import bridge.resources.PLATE_FALSE
import bridge.resources.PLATE_TRUE

data class BridgeGameInfo(
    var bridge: List<String> = emptyList(),
    var stage: List<Boolean> = mutableListOf(),
    var countOfTry: Int = 0
) {
    fun getBridge(bridgeGameType: BridgeGameType) = stage
        .mapIndexed { i, status ->
            when (bridge[i]) {
                bridgeGameType.type -> if (status) PLATE_TRUE else PLATE_FALSE
                else -> PLATE_BLANK
            }
        }
}
