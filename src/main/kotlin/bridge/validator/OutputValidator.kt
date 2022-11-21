package bridge.validator

object OutputValidator {

    fun validatePrintMap(bridge: List<String>, round: Int, direction: String): String {

        return validateUpSideMap(bridge, round, direction) + "\n" + validateDownSideMap(bridge, round, direction)
    }

    // TODO: 리팩토링
    private fun validateUpSideMap(bridge: List<String>, round: Int, direction: String): String {
        val truncatedUpList: MutableList<String> = mutableListOf()
        if (bridge[round] == "U" && direction == "U") truncatedUpList.add(" O ")
        if (bridge[round] == "U" && direction == "D") truncatedUpList.add("   ")
        if (bridge[round] == "D" && direction == "U") truncatedUpList.add(" X ")
        if (bridge[round] == "D" && direction == "D") truncatedUpList.add("   ")
        return truncatedUpList.toString().replace(", ", "|")
    }

    private fun validateDownSideMap(bridge: List<String>, round: Int, direction: String): String {
        val truncatedDownList: MutableList<String> = mutableListOf()
        if (bridge[round] == "U" && direction == "U") truncatedDownList.add("   ")
        if (bridge[round] == "U" && direction == "D") truncatedDownList.add(" X ")
        if (bridge[round] == "D" && direction == "U") truncatedDownList.add("   ")
        if (bridge[round] == "D" && direction == "D") truncatedDownList.add(" O ")
        return truncatedDownList.toString().replace(", ", "|")
    }

    fun validatePrintResult(whether: Boolean, trialCount: Int): String {
        TODO("Not yet implemented")
    }
}