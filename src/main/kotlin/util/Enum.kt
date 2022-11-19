package util

class Enum {
    enum class RESULT(val emoji: String, val korean: String) {
        SUCCESS("O", "성공"),
        FAILURE("X", "실패");
    }

    enum class OPTION(val command: String) {
        QUIT("Q"),
        RESTART("R");
    }

    enum class SIDE(val code: Int, val command: String) {
        DOWN(0, "D"),
        UP(1, "U");
    }
}