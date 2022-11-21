package bridge.view.validator

import bridge.view.InputView

object OutputValidator {
    private val upSideList: MutableList<String> = mutableListOf()
    private val downSideList: MutableList<String> = mutableListOf()

    fun validatePrintMap(bridge: List<String>, round: Int): String {
        val moving = InputView().readMoving()
        upSideList.add(validateUpSideMap(bridge, round, moving))
        downSideList.add(validateDownSideMap(bridge, round, moving))
        println(upSideList.toString().replace(", ", "|"))
        println(downSideList.toString().replace(", ", "|"))
        return moving
    }

    // TODO: 리팩토링
    fun validateUpSideMap(bridge: List<String>, round: Int, moving: String): String {
        if (bridge[round] == "U" && moving == "U") return " O "
        if (bridge[round] == "U" && moving == "D") return "   "
        if (bridge[round] == "D" && moving == "U") return " X "
        if (bridge[round] == "D" && moving == "D") return "   "
        return ""
    }

    fun validateDownSideMap(bridge: List<String>, round: Int, moving: String, ): String {
        if (bridge[round] == "U" && moving == "U") return "   "
        if (bridge[round] == "U" && moving == "D") return " X "
        if (bridge[round] == "D" && moving == "U") return "   "
        if (bridge[round] == "D" && moving == "D") return " O "
        return ""
    }

}