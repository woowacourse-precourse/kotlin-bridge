package bridge.domain

import bridge.util.DOWN
import bridge.util.UP

class BridgeMap(
    private val route: List<ArrayList<Mark>> = listOf(arrayListOf(), arrayListOf())
) {
    fun makeRoute(path: Path, bridge: Bridge): List<List<Mark>> {
        route[0].add(Mark.DEFAULT)
        route[1].add(Mark.DEFAULT)

        for (round in 0 until path.currentRound()) {
            constructRouteOf(round, path, bridge)
        }
        return route
    }

    private fun constructRouteOf(round: Int, path: Path, bridge: Bridge) {
        val bridgeDirection = bridge.getDirection(round)
        val isCorrectPath = path.checkDirection(bridgeDirection, round)
        val userDigitDirection = path.userDirectionAsDigit(round)

        if (isCorrectPath) {
            markCorrectPath(bridgeDirection, userDigitDirection, round)
        } else {
            markWrongPath(bridgeDirection, userDigitDirection, round)
        }
    }

    private fun markCorrectPath(bridgeDirection: String, userDirection: Int, round: Int) {
        when (bridgeDirection) {
            UP -> route[userDirection][round] = Mark.CORRECT
            DOWN -> route[userDirection][round] = Mark.CORRECT
        }
    }

    private fun markWrongPath(bridgeDirection: String, userDirection: Int, round: Int) {
        when (bridgeDirection) {
            UP -> route[userDirection][round] = Mark.WRONG
            DOWN -> route[userDirection][round] = Mark.WRONG
        }
    }

    fun route() = route
}