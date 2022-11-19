package bridge

class OutputView {
    private val upperMap = mutableListOf<String>()
    private val lowerMap = mutableListOf<String>()
    private var gameResult = 0 // == default win

    fun mapCase1() {
        upperMap.add(" O ")
        lowerMap.add("   ")
    }
    fun mapCase2() {
        upperMap.add("   ")
        lowerMap.add(" O ")
    }
    fun mapCase3() {
        upperMap.add("   ")
        lowerMap.add(" X ")
        gameResult = 1 // == loss
    }
    fun mapCase4() {
        upperMap.add(" X ")
        lowerMap.add("   ")
        gameResult = 1
    }

    fun printMap(bridge: List<String>, movingResult: List<String>): Int{
        for (i in 0 until movingResult.size) {
            if (movingResult[i] == "O" && bridge[i] == "U") mapCase1()
            if (movingResult[i] == "O" && bridge[i] == "D") mapCase2()
            if (movingResult[i] == "X" && bridge[i] == "U") { mapCase3()
                break }
            if (movingResult[i] == "X" && bridge[i] == "D") { mapCase4()
                break } }
        println(upperMap.toString().replace(", ","|"))
        println(lowerMap.toString().replace(", ","|")+"\n")
        return gameResult
    }

    fun printResult(bridge: List<String>, movingResult: List<String>, gameCommand: String, tryCount: Int) {
        println("최종 게임 결과")
        OutputView().printMap(bridge, movingResult)
        if (gameCommand == "Q") println("게임 성공 여부: 실패")
        if (gameCommand == "R") println("게임 성공 여부: 성공")
        println("총 시도한 횟수: " + tryCount)
    }
}