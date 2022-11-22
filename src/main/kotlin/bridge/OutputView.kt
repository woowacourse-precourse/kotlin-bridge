package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */


class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    companion object {

        fun printStart() {
            println(BridgeMessage.Start.word)
        }

        fun getBridgeSize() {
            println(BridgeMessage.GiveMeBridgeSize.word)
        }

        fun getBridgeMoving() {
            println(BridgeMessage.WhereAreYouGo.word)
        }

        fun printMap(map: String) {
            println(map)
        }

        fun areYouRetry() {
            println(BridgeMessage.AreYouWantRetry.word)
        }

        fun printGameEndMessage() {
            println(BridgeMessage.End.word)
        }

        fun printResult(successRecord: List<Boolean>, count: Int) {
            if (successRecord.last())
                println(BridgeMessage.Win.word)
            else
                println(BridgeMessage.Lose.word)
            println(BridgeMessage.HowManyTimeDidYouTry.word + count)
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
}
