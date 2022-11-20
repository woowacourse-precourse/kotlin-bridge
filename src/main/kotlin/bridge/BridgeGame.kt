package bridge

import bridge.validator.BridgeGameValidator

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    /*진행 메소드
    *
    * */
    fun start() {
        progress()
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 일치했을 때 (true) - 다음 라운드 반환
     * 틀렸을 때 (false) - 현재 라운드 반환
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(isMatched: Boolean): Int {
        return BridgeGameValidator.validateMoveOutput(isMatched)
    }

    /*
    * 전체적인 게임 진행 과정
    * */
    fun progress(): Boolean {
/*        val bridgeSize = InputView().readBridgeSize()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)*/
        // 오답일 때
        while (true) {
            val moving = InputView().readMoving()
            val map = OutputView().printMap(listOf("U"), 0, moving)
            println(map)
            val isNotMatched = ("U" != moving)
            if (isNotMatched) {
                val gameCommand = InputView().readGameCommand()
                if (gameCommand == "Q") {
                    OutputView().printResult(map, 0, isNotMatched)
                }
                if (gameCommand == "R") {
                    continue
                }
            }
            return true
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun retry() {}
}
