package bridge.validator

object OutputValidator {

    fun validatePrintMap(bridge: List<String>, round: Int, direction: String): String {
        // 첫번째가 U일 때
        if (bridge[round] == direction) return "[ O ]\n[   ]"
        if (bridge[round] != direction) return "[   ]\n[ X ]"
        return ""
    }
}