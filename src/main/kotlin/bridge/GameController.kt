package bridge

class GameController {
    fun moveStart(bridge : List<String>){
        var userRoute = mutableListOf<String>()
        var bridgeGame = BridgeGame(userRoute)

        var upDown = listOf("U","D")
        while (userRoute != bridge){
            var userMove = InputView().readMoving()
            userRoute = bridgeGame.move(bridge, userMove, upDown)
            if (userRoute[0] == "break") break
        }
    }
}