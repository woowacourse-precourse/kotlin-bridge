package constant

enum class Symbol(val symbol: String) {
    SUCCESS("O"),
    FAIL("X"),
    NOTHING(" "),

    START_BRIDGE("[ "),
    SEPARATOR(" | "),
    END_BRIDGE(" ]")
}