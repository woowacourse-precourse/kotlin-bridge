package bridge.View

import bridge.*
import bridge.computer.firstLine
import bridge.computer.secondLine
import bridge.utils.BridgePrint
import bridge.utils.Messages

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {
        print(BridgePrint._start)
        for (number in (0..firstLine.size - 1)) {
            print(firstLine[number])
            if (firstLine.size > 1 && number < firstLine.size -1) {
                print(BridgePrint._wall)
            }
        }
        println(BridgePrint._end)

        print(BridgePrint._start)
        for (number in (0..secondLine.size - 1)) {
            print(secondLine[number])
            if (firstLine.size > 1 && number < firstLine.size -1) {
                print(BridgePrint._wall)
            }
        }
        println(BridgePrint._end)
        println()

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {
        println(Messages.GameLastResult)
        OutputView().printMap()
//        게임의 성공 실패에 따라서 제공되는 메세지
        if (isGameClear) {
            println(Messages.GameSuccess)
        }
        if (!isGameClear) {
            println(Messages.GameFail)
        }
//        게임 실행 횟수에 따라 제공되는 메세지
        print(Messages.GameTryTimes)
        println(gameCount)
    }
}
