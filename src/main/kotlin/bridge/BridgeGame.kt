package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    var userRoute = mutableListOf<String>()
    var times = 1
    var control = 0
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge : List<String>) {
        var upDown = listOf("U","D")
        while (userRoute != bridge){
            var userMove = InputView().readMoving()
            userRoute.add(userMove)

            for (move in upDown) { control = OutputView().printMap(bridge, userRoute, move) }
            if (wrongAnswer(bridge, upDown) == "break") break
            if (userRoute == bridge) { correctAnswer(bridge, upDown) }
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

    fun wrongAnswer(bridge: List<String>, upDown : List<String>) : String{
        if (control == 1){
            var gameControl = InputView().readGameCommand()
            if (gameControl == "Q"){
                OutputView().printResult(bridge, userRoute, upDown)
                return "break"
            }
            if (gameControl == "R") { retry() }
        }
        return ""
    }

    fun correctAnswer(bridge: List<String>, upDown: List<String>){
        OutputView().printResult(bridge, userRoute, upDown)
        OutputView().printGameSituation(control, times)
    }
}
