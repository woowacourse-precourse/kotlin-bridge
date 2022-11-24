package bridge.domain.game

class BridgeCrossingMap {

    private val _upstairs = mutableListOf<Char>()
    val upstairs: List<Char>
        get() = _upstairs

    private val _downstairs = mutableListOf<Char>()
    val downstairs: List<Char>
        get() = _downstairs

    fun add(floor: Bridge.Floor, isCorrect: Boolean) {
        val value = if (isCorrect) CORRECT else WRONG

        if (floor == Bridge.Floor.Up) {
            _upstairs.add(value)
            _downstairs.add(EMPTY)
        } else if (floor == Bridge.Floor.Down) {
            _upstairs.add(EMPTY)
            _downstairs.add(value)
        }
    }

    companion object {
        private const val CORRECT = 'O'
        private const val WRONG = 'X'
        private const val EMPTY = ' '
    }
}