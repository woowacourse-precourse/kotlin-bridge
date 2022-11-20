package bridge.service

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.bridge.Bridge
import bridge.domain.counter.TryCounter
import bridge.domain.map.RouteMap
import bridge.domain.path.Path
import bridge.domain.result.RoundResult
import bridge.util.constant.INITIAL_TRY_COUNT

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame : GameService {
    private lateinit var bridge: Bridge
    private lateinit var playerRoute: RouteMap
    private val bridgeMaker: BridgeMaker by lazy { BridgeMaker(BridgeRandomNumberGenerator()) }
    private val tryCounter: TryCounter by lazy { TryCounter(INITIAL_TRY_COUNT) }
    private var playerPath = Path()


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */

    fun move(direction: String) {
        playerPath = playerPath.add(direction)
        playerRoute = playerRoute.addPath(playerPath, bridge)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */

    fun retry() {
        initPath()
        initPlayerRoute()
        increaseTryCount()
    }


    fun startBridgeGame() {
        initPlayerRoute()
    }

    fun startRound(round: Int): RoundResult {
        val realDirection = bridge.directionOf(round)
        val isRightPath = playerPath.checkDirection(realDirection, round)

        if (isRightPath) {
            return RoundResult(round, Result.SUCCESS, playerRoute, tryCounter.count())
        }
        return RoundResult(round, Result.FAIL, playerRoute, tryCounter.count())
    }

    fun generateBridge(bridgeSize: Int) {
        bridge = Bridge(bridgeMaker.makeBridge(bridgeSize))
    }

    private fun initPath() {
        playerPath = playerPath.init()
    }

    private fun initPlayerRoute() {
        playerRoute = RouteMap()
    }

    fun bridgeSize() = bridge.size

    fun finalPosition() = bridge.size - 1

    fun currentPlayerRoute() = playerRoute

    private fun increaseTryCount() = tryCounter.plus()
}