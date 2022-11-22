package bridge

enum class MovementStatus(val direction: String, val status: String) {
    UP_RIGHT("U", "O"),
    UP_WRONG("U", "X"),
    DOWN_RIGHT("D", "O"),
    DOWN_WRONG("D", "X");
}