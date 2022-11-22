package bridge.domain.result

import bridge.domain.map.RouteMap
import bridge.service.Result

data class RoundResult(
    val round: Int,
    val result: Result,
    val playerRoute: RouteMap,
    val tryCount: Int
)