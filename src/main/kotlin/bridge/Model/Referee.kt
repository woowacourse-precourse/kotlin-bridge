package bridge.Model

class Referee(private val bridgeShapes: List<String>, private val location: Int) {
    fun judgeMove(move: String): String {
        var shape = bridgeShapes[location]
        if (shape == move) {
            return "O"
        }
        return "X"
    }
}