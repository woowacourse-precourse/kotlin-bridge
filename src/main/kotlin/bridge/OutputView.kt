package bridge


class OutputView {

    fun printMap(upCase: MutableList<String>, downCase: MutableList<String>) {
        println(upCase.joinToString ( " | ", "[ ", " ]" ))
        println(downCase.joinToString ( " | ", "[ ", " ]" ))
    }


    fun printResult(isSuccess: Boolean, totalCount: Int) {
        when(isSuccess) {
            true -> println(ConstantMessage.BRIDGE_GAME_SUCCESS)
            false -> println(ConstantMessage.BRIDGE_GAME_FAIL)
        }
        print(ConstantMessage.TOTAL_TRY_COUNT)
        println("$totalCount")
    }
}
