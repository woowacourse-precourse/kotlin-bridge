package bridge

import bridge.BridgeGameStarter.Companion.moving

class BridgeGame {

    companion object{
        var cntMoving = 0
    }

    fun bridgeSetting(): List<String>{
        val bridgeSize = InputView().readBridgeSize()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        return bridge
    }

    fun move(nextMoving: String, bridge: List<String>): List<String> {
        if (nextMoving == bridge[cntMoving]) moving.add(nextMoving)
        else if (nextMoving != bridge[cntMoving]) moving.add(nextMoving+"F")

        cntMoving++
        return moving
    }

    fun retry() {}

}