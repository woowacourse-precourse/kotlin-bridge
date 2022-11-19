package bridge.domain.route

import bridge.domain.bridge.Bridge
import bridge.domain.path.Path
import bridge.util.DOWN
import bridge.util.UP

class Route(
    private val route: List<ArrayList<Mark>> = listOf(arrayListOf(), arrayListOf()),
    private val bridge: Bridge
) {
    fun addPath(path: Path): Route {
        route[0].add(Mark.DEFAULT)
        route[1].add(Mark.DEFAULT)
        updatePath(path, path.position())

        return Route(route, bridge)
    }

    private fun updatePath(path: Path, position: Int) {
        val bridgeDirection = bridge.directionOf(position)
        val playerDirection = path.userDirectionAsDigit(position)
        val isCorrectPath = path.checkDirection(bridgeDirection, position)

        if (isCorrectPath) {
            markCorrectPath(bridgeDirection, playerDirection, position)
        } else {
            markWrongPath(bridgeDirection, playerDirection, position)
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

    fun asList() = route
}