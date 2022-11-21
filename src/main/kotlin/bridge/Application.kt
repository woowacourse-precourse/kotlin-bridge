package bridge

fun checkUserInput(index: Int, bridgeGame: BridgeGame,outputView: OutputView): Int {
    val result =  bridgeGame.move(index, InputView().readMoving())
    if(result == Result.USER_INPUT_CORRECT.message) {
        outputView.printMap(index, true)
        return Constant.CORRECT.params
    }
    if(result == Result.USER_INPUT_WRONG.message) {
        outputView.printMap(index,false)
        return Constant.WRONG.params
    }
    return Constant.ERROR.params
}
fun checkUserGameCommand(bridge: List<String>,tryCount: Int,idx:Int): Int {
    val userGameCommand = InputView().readGameCommand()
    if (userGameCommand==Result.USER_COMMAND_RETRY.message)
        return playGame(bridge, BridgeGame(bridge).retry(tryCount))
    if (userGameCommand==Result.USER_COMMAND_QUIT.message){
        OutputView(bridge).printResult(idx, tryCount)
        return Constant.WRONG.params
    }
    return Constant.ERROR.params
}

fun playGame(bridge:List<String>,tryCount:Int): Int {
    for(idx in bridge.indices) {
        if (checkUserInput(idx, BridgeGame(bridge), OutputView(bridge))==Constant.WRONG.params) {
            return checkUserGameCommand(bridge,tryCount,idx)
        }
    }
    return tryCount
}
fun main() {
    println(OutputView.Message.GAMESTART.message)
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    val finalTryCount = playGame(bridge,Constant.TRY_COUNT.params)
    if (finalTryCount !=Constant.CORRECT.params || finalTryCount !=Constant.ERROR.params)
        OutputView(bridge).printResult(bridge.size,finalTryCount)
}
enum class Constant(
        val params:Int
){
    CORRECT(1),
    WRONG(0),
    ERROR(-1),
    TRY_COUNT(1)
}
enum class Result(
        val message:String
){
    USER_INPUT_CORRECT("Correct"),
    USER_INPUT_WRONG("Wrong"),
    USER_COMMAND_RETRY("R"),
    USER_COMMAND_QUIT("Q")
}