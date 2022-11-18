package bridge

class Enum {
    enum class RESULT(val emoji: String, val korean: String) {
        SUCCESS("O", "성공"),
        FAILURE("X", "실패");
    }

    enum class OPTION(val command: String) {
        QUIT("Q"),
        RESTART("R");
    }

    enum class SIDE(val command: String, val number: Int) {
        UP("U", 1),
        DOWN("D", 0);
    }
}