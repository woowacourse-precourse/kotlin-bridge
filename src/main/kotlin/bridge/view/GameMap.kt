package bridge.view

import bridge.model.GameMapStatus

class GameMap(gameMapStatus: GameMapStatus) {

    private val lines = mutableMapOf<String, Line>()

    init {
        initLines(gameMapStatus)
        markOnLines(gameMapStatus)
    }

    private fun initLines(gameMapStatus: GameMapStatus) {
        val mapSize = gameMapStatus.userHistory.size
        lines[UP] = Line(mapSize)
        lines[DOWN] = Line(mapSize)
    }

    private fun markOnLines(gameMapStatus: GameMapStatus) {
        (0 until gameMapStatus.userHistory.size).forEach {
            lines[gameMapStatus.userHistory[it]]!!.mark(
                it,
                if (gameMapStatus.bridge[it] == gameMapStatus.userHistory[it]) MATCHED else NOT_MATCHED
            )
        }
    }

    class Line(size: Int) {
        private val squares: MutableList<String>

        init {
            squares = (1..size).map { EMPTY }.toMutableList()
        }

        fun mark(index: Int, mark: String) {
            squares[index] = mark
        }

        override fun toString(): String = LEFT_BORDER + squares.joinToString(SPLIT_LINE) + RIGHT_BORDER + "\n"

        companion object {
            private const val LEFT_BORDER = "[ "
            private const val RIGHT_BORDER = " ]"
            private const val SPLIT_LINE = " | "
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