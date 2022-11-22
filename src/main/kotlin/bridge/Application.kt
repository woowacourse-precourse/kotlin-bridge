package bridge

fun playinggame (playround : Int, size : Int, gamemap: List<String>) {
    val output = OutputView()
    val input = InputView()
    var ox  = mutableListOf<Pair<String, String>>()
    for(i in 0..size-1 step 1) {
        ox = comparelist(gamemap, ox, i)
        if (ox[i].first.contains("X") || ox[i].second.contains("X")) break
    }
    var wingame = countdone(ox, size)
    var quit = ""
    if (ox.size != size ) { quit = restartgame(playround, size, gamemap)}
    if (quit == "Q" || wingame == "성공") {
        output.printResult1(ox, size)
        output.printResult2(wingame, playround)
    }
}
fun comparelist(gamemap: List<String>, output : MutableList<Pair<String, String>> ,size : Int) : MutableList<Pair<String, String>>{ // 입력인자랑 랜덤 맵비교
    val input = InputView().readMoving()
    if (gamemap[size] == input && input == "U")  {output += Pair(" O ", "   ") }
    else if (gamemap[size] != input && input == "U")   {output += Pair(" X ", "   ")}
    else if (gamemap[size] == input && input == "D")  {output += Pair("   ", " O ")  }
    else if (gamemap[size] != input && input == "D")  {output += Pair("   ", " X ") }
    OutputView().printMap(output, size)
    return output
}

fun countdone(output: MutableList<Pair<String, String>>, size: Int) : String{
    if (output.size != size || size == 0) return "실패"
    if (output.size == size) return "성공"
    return ""
}

fun restartgame (playround: Int, size: Int, gamemap: List<String>) : String{
    val input = InputView()
    var playround = playround
    when (input.readGameCommand()) {
        "R" -> { playround += 1 ; playinggame(playround, size, gamemap); return ""}
        "Q" -> return "Q"
        else -> return ""
    }
}

fun main() {
    val input = InputView()
    val playround = 1
    OutputView().startgame()
    var size = input.readBridgeSize()
    var gamemap = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size.toInt())
    playinggame(playround, size, gamemap)
}

