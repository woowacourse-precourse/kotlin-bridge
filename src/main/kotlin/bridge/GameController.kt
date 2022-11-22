package bridge

class GameController {
    fun userMove() : String{
        var inputView = InputView()
        return inputView.readMoving()
    }

    fun printMap(bridge : List<String>, userRoute : MutableList<String>, move : String) : Int{
        var outputView = OutputView()
        return outputView.printMap(bridge, userRoute, move)
    }

    fun printFinalMap(bridge: List<String>, userRoute: MutableList<String>) {
        var upDown = listOf("U","D")
        var outputView = OutputView()
        println("최종 게임 결과")
        for (move in upDown){
            outputView.printResult(bridge, userRoute, move)
        }
    }
    fun printFinalExplain(control : Int, times : Int){
        var outputView = OutputView()
        outputView.printGameSituation(control, times)
    }

    fun gameControl() : String{
        var inputView = InputView()
        return inputView.readGameCommand()
    }
}