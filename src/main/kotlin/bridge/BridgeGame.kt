package bridge

class BridgeGame {
    private var playerLocation = -1
    private var playerTryCount = 1
    private val roadUntilNow = RoadMap()


    fun move(playerInput: String, bridge: Bridge): Boolean {
        val nextMv = bridge.checkNextMove(playerInput, playerLocation)

        if (nextMv) roadUntilNow.addSuccessRoad(playerInput)
        else roadUntilNow.addFailRoad(playerInput)

        playerLocation++

        return nextMv
    }

    fun retry() {
        resetPlayer()
        playerTryCount++
    }

    fun getPlayerTryCount(): Int {
        return playerTryCount
    }

    fun getRoadUntilNow(): RoadMap {
        return roadUntilNow
    }

    fun getPlayerLocation(): Int {
        return playerLocation
    }

    private fun resetPlayer() {
        roadUntilNow.resetRoadMap()
        playerLocation = -1
    }


}
