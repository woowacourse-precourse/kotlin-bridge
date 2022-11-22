package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(userRoute : MutableList<String>, times : Int, control : Int) {
    var userRoute = userRoute
    var times = times
    var control = control
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge : List<String>) {
        var upDown = listOf("U","D")
        while (userRoute != bridge){
            userRoute.add(GameController().userMove())
            for (move in upDown) { bridgeMap(bridge, move) }
            if (wrongAnswer(bridge) == "break") break
            if (userRoute == bridge) { finalStage(bridge) }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        userRoute.removeAt(userRoute.size-1)
        control = 0
        times++
    }

    fun bridgeMap(bridge: List<String>, move : String){
        if (control == 1){
            GameController().printMap(bridge, userRoute, move)
        }
        if (control != 1) {
            control = GameController().printMap(bridge, userRoute, move)
        }
    }

    fun finalStage(bridge: List<String>){
        var gameController = GameController()
        gameController.printFinalMap(bridge, userRoute)
        gameController.printFinalExplain(control, times)
    }

    fun wrongAnswer(bridge: List<String>) : String{
        if (control == 1){
            var gameControl = GameController().gameContiol()
            if (gameControl == "Q"){
                finalStage(bridge)
                return "break"
            }
            if (gameControl == "R") { retry() }
        }
        return ""
    }
}
