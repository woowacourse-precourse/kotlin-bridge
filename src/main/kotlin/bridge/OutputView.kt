package bridge

import output.Output

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(markUp: MutableList<String>, markDown: MutableList<String>) {
        println(markUp.joinToString(" | ", "[ ", " ]"))
        println(markDown.joinToString(" | ", "[ ", " ]\n"))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(markUp: MutableList<String>, markDown: MutableList<String>, numberOfTry: Int) {
        println(Output.RESULT_GAME.output)
        OutputView().printMap(markUp, markDown)
        println(Output.SUCCESS_OR_NOT.output.plus(Output.FAIL.output))
        println(Output.TRY_ATTEMPT.output.plus(numberOfTry))
    }

    fun printResultSuccess(markUp: MutableList<String>, markDown: MutableList<String>, numberOfTry: Int) {
        println(Output.RESULT_GAME.output)
        OutputView().printMap(markUp, markDown)
        println(Output.SUCCESS_OR_NOT.output.plus(Output.SUCCESS.output))
        println(Output.TRY_ATTEMPT.output.plus(numberOfTry))
    }
}
