package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge : List<String>) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(index:Int,tryCount:Int) {
        // TODO: 리팩토링 필요
        if (index == bridge.size)
            OutputView().printResult(index, bridge, tryCount)
        else {
            val userMovingInput = InputView().readMoving()
            if (userMovingInput == bridge[index]) {
                OutputView().printMap(index, bridge, true)
                move(index + 1, tryCount)
            }
            else {
                OutputView().printMap(index, bridge, false)
                val userCommandInput = InputView().readGameCommand()
                if (userCommandInput == "R")
                    retry(tryCount)
                if (userCommandInput == "Q")
                    OutputView().printResult(index, bridge, tryCount)
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(tryCount: Int) {
        move(0,tryCount+1)
    }
}
