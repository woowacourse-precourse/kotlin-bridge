package bridge

import ui.InputView
import ui.OutputView

/**
 * 다리 건너기 게임의 진행을 관리하는 클래스
 */
class BridgeGameController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()
    private val bridgeGame: BridgeGame = BridgeGame()

    fun runGame() {
        setGameInfoInit()

        while (bridgeGame.getMoveCount() < bridgeGame.getBridgeSize()) {
            println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
            bridgeGame.move(inputView.readMoving())
            outputView.printMap(bridgeGame.getGameProgress())

            if(!bridgeGame.isSuccess()) {
                println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
                if(inputView.readGameCommand() == "R") bridgeGame.retry()
                else break
            }
        }

        outputView.printResult(bridgeGame)
    }

    private fun setGameInfoInit() {
        println("다리 건너기 게임을 시작합니다.")
        println()
        println("다리의 길이를 입력해주세요.")
        bridgeGame.setBridgeSize(inputView.readBridgeSize())
        println()

        val bridgeRandomGenerator = BridgeRandomNumberGenerator()
        bridgeGame.setBridge(BridgeMaker(bridgeRandomGenerator).makeBridge(bridgeGame.getBridgeSize()))
    }

}