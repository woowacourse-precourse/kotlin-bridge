package util

class Enum {
    enum class RESULT(val emoji: String, val korean: String) {
        SUCCESS("O", "성공"),
        FAILURE("X", "실패");
    }

    enum class SIDE(val command: String) {
        DOWN("D"),
        UP( "U");
    }
}