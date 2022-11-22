package bridge.view

import bridge.model.GameMapStatus

class GameMap(gameMapStatus: GameMapStatus) {

    private val lines = mutableMapOf<String, Line>()

    init {
        val mapSize = gameMapStatus.userHistory.size
        lines[UP] = Line(mapSize)
        lines[DOWN] = Line(mapSize)
        (0 until gameMapStatus.userHistory.size).forEach {
            if (gameMapStatus.bridge[it] == gameMapStatus.userHistory[it])
                lines[gameMapStatus.userHistory[it]]!!.mark(it, MATCHED)
            else
                lines[gameMapStatus.userHistory[it]]!!.mark(it, NOT_MATCHED)
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