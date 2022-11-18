package bridge.domain

import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_LOWER_INCLUSIVE
import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_UPPER_INCLUSIVE
import bridge.util.*

class BridgeMap(
    private val map: Array<Array<Mark>>, private val bridge: Bridge, private val path: Path
) {
    fun makeMap(): Array<Array<Mark>> {
        val lastRound = map[0].size
        for (round in 0 until lastRound) {
            constructOf(round)
        }
        return map
    }

    private fun constructOf(round: Int) {
        val bridgeDirection = bridge.getDirection(round)
        val isCorrectPath = path.checkDirection(bridgeDirection, round)

        if (isCorrectPath) {
            markCorrectPath(bridgeDirection, round)
        } else {
            markWrongPath(bridgeDirection, round)
        }
    }

    private fun markCorrectPath(bridgeDirection: String, round: Int) {
        when (bridgeDirection) {
            UP -> map[RANDOM_UPPER_INCLUSIVE][round] = Mark.CORRECT
            DOWN -> map[RANDOM_LOWER_INCLUSIVE][round] = Mark.CORRECT
        }
    }

    private fun markWrongPath(bridgeDirection: String, round: Int) {
        when (bridgeDirection) {
            UP -> map[RANDOM_UPPER_INCLUSIVE][round] = Mark.WRONG
            DOWN -> map[RANDOM_LOWER_INCLUSIVE][round] = Mark.WRONG
        }
    }

    companion object {
        fun defaultMap(round: Int): Array<Array<Mark>> {
            return Array(DIRECTION_SIZE) { Array(round) { Mark.DEFAULT } }
        }
    }
}