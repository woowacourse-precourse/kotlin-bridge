package bridge.view

import bridge.model.GameMapState

class GameMap(gameMapState: GameMapState) {

    private val lines = mutableMapOf<String, Line>()

    init {
        val mapSize = gameMapState.userHistory.size
        lines[UP] = Line(mapSize)
        lines[DOWN] = Line(mapSize)
        (0 until gameMapState.userHistory.size).forEach {
            if (gameMapState.bridge[it] == gameMapState.userHistory[it])
                lines[gameMapState.userHistory[it]]!!.mark(it, MATCHED)
            else
                lines[gameMapState.userHistory[it]]!!.mark(it, NOT_MATCHED)
        }
    }

    class Line(size: Int) {
        private val elements: MutableList<String>

        init {
            elements = (1..size).map { EMPTY }.toMutableList()
        }

        fun mark(point: Int, mark: String) {
            elements[point] = mark
        }

        override fun toString(): String = LEFT + elements.joinToString(SPLIT) + RIGHT + "\n"

        companion object {
            private const val LEFT = "[ "
            private const val RIGHT = " ]"
            private const val SPLIT = " | "
            private const val EMPTY = " "
        }
    }

    override fun toString(): String = lines[UP].toString() + lines[DOWN].toString()

    companion object {
        private const val UP = "U"
        private const val DOWN = "D"
        private const val MATCHED = "O"
        private const val NOT_MATCHED = "X"
    }
}