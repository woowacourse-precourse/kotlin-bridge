package bridge.view.strings

object Command {

    enum class Power(val command: String) {
        Retry("R"), Quit("Q");

        override fun toString(): String = command

        companion object {
            fun parse(command: String): Power? = values().find { it.command == command }
        }
    }
}