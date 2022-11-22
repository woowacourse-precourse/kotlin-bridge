package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(userRoute : MutableList<String>) {
    var userRoute = userRoute
    var times = 1
    var control = 0
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge : List<String>, userMove : String, upDown: List<String>) : MutableList<String>{
        userRoute.add(userMove)
        for (move in upDown) { printMap(bridge, move) }
        if (wrongAnswer(bridge, upDown) == "break") {
            return mutableListOf("break")
        }
        if (userRoute == bridge) { finalStage(bridge, upDown) }
        return userRoute
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

    fun printMap(bridge: List<String>, move : String){
        if (control == 1){
            OutputView().printMap(bridge, userRoute, move)
        }
        if (control != 1) {
            control = OutputView().printMap(bridge, userRoute, move)
        }
    }

    fun finalStage(bridge: List<String>, upDown: List<String>){
        println("최종 게임 결과")
        for (move in upDown){
            OutputView().printResult(bridge, userRoute, move)
        }
        OutputView().printGameSituation(control, times)
    }

    fun wrongAnswer(bridge: List<String>, upDown : List<String>) : String{
        if (control == 1){
            var gameControl = InputView().readGameCommand()
            if (gameControl == "Q"){
                finalStage(bridge, upDown)
                return "break"
            }
            if (gameControl == "R") { retry() }
        }
        return ""
    }
}
