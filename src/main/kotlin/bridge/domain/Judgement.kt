package bridge.domain

class Judgement {
    fun compareDirection(playerDirection: String, computerDirection: String): String {
        if (playerDirection == computerDirection) {
            return "O"
        }
        return "X"
    }
}