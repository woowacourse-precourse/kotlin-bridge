package bridge.validator

import bridge.InputView

object OutputValidator {

    fun validatePrintMap(upSideList: MutableList<String>, downSideList: MutableList<String>, round: Int): String {
        val moving = InputView().readMoving()
        upSideList.add(validateUpSideMap(upSideList, round, moving))
        downSideList.add(validateDownSideMap(downSideList, round, moving))
        println(upSideList.toString().replace(", ", "|"))
        println(upSideList.toString().replace(", ", "|"))
        return moving
    }

    // TODO: 리팩토링
    fun validateUpSideMap(upSideList: List<String>, round: Int, direction: String): String {
        if (upSideList[round] == "U" && direction == "U") return " O "
        if (upSideList[round] == "U" && direction == "D") return "   "
        if (upSideList[round] == "D" && direction == "U") return " X "
        if (upSideList[round] == "D" && direction == "D") return "   "
        return ""
    }

    fun validateDownSideMap(downSideList: List<String>, round: Int, direction: String, ): String {
        if (downSideList[round] == "U" && direction == "U") return "   "
        if (downSideList[round] == "U" && direction == "D") return " X "
        if (downSideList[round] == "D" && direction == "U") return "   "
        if (downSideList[round] == "D" && direction == "D") return " O "
        return ""
    }

    fun validatePrintResult(whether: Boolean, trialCount: Int): String {
        TODO("Not yet implemented")
    }
}