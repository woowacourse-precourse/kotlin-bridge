package bridge

import ui.InputView

/**
 * 다리 건너기 게임의 진행을 관리하는 클래스
 */
class BridgeGameController {
    val inputView: InputView = InputView()
    val bridgeGame: BridgeGame = BridgeGame()

    fun setGameInfoInit() {
        println("다리 건너기 게임을 시작합니다.")
        println()
        println("다리의 길이를 입력해주세요.")
        println()

        bridgeGame.setBridgeSize(inputView.readBridgeSize())
        bridgeGame.setBridge(BridgeMaker(BridgeRandomNumberGenerator()))
    }

}