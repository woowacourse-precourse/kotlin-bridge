package bridge

var count:Int = 1
class BridgeGameProgress {

    fun bridgeGameProgress(bridge: List<String>){
        val result = bridgeGameStart(bridge)
        if(result[result.size-1][1]==FAIL){
            count += 1
            gameCommand(result, bridge)
        }
        return OutputView().printResult(result, SUCCESS, count)
    }

    private fun bridgeGameStart(bridge: List<String>): MutableList<List<String>> {
        val result: MutableList<List<String>> = mutableListOf()
        selectUpDown(bridge, result)
        return result
    }

    private fun gameCommand(result: MutableList<List<String>>, bridge: List<String>){
        val gameCommand = InputView().readGameCommand()
        if(gameCommand== QUIT){
            return OutputView().printResult(result, LOSE, count)
        }
        if(gameCommand == RETRY){
            BridgeGame().retry(bridge)
            return
        }
    }

    private fun selectUpDown(bridge: List<String>, result: MutableList<List<String>>) {
        for (step in bridge) {
            OutputView().printSelectMove()
            val moving = InputView().readMoving()
            if (!BridgeGame().move(step, moving, result)) {
                OutputView().printMap(result)
                break
            }
            OutputView().printMap(result)
        }
    }
}