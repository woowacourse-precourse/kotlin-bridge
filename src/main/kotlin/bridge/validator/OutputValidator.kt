package bridge.validator

object OutputValidator {

    fun validatePrintMap(bridge: List<String>, round: Int, direction: String): String {
        if (bridge[round] == "U" && direction == "U") return "[ O ]\n[   ]"
        if (bridge[round] == "U" && direction == "D") return "[   ]\n[ X ]"
        if (bridge[round] == "D" && direction == "U") return "[ X ]\n[   ]"
        if (bridge[round] == "D" && direction == "D") return "[   ]\n[ O ]"

        return ""
    }

    fun validatePrintResult(whether: Boolean, trialCount: Int): String {
        TODO("Not yet implemented")
    }
}