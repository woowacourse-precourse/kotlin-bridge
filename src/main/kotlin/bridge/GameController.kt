package bridge

import bridge.view.InputView
import bridge.view.OutputView

class GameController {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()

    init {
        bridgeGame.tryCount++
        println("다리 건너기 게임을 시작합니다.")
    }

    fun gameStart() {
        makeBridge(inputBridgeSize())
        repeatMoving()
        if(!bridgeGame.checkGameWin()){
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
            if(inputView.readGameCommand()=="R"){
                bridgeGame.retry()
                return gameStart()
            }
        }
        outputView.printResult(bridgeGame.currentMoving,judgeMoving(),bridgeGame.tryCount)
    }

    private fun inputBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        return inputView.readBridgeSize()
    }

    private fun makeBridge(size: Int) {
        bridgeGame.createCorrectBridgeMap(size)
    }

    private fun repeatMoving() {
        while (true) {
            if (bridgeGame.checkGameOver()) {
                break
            }
            moving()
            outputMoving()
        }
    }

    private fun moving() {
        bridgeGame.move(inputMoving())
    }

    private fun inputMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        return inputView.readMoving()
    }

    private fun outputMoving() {
        outputView.printMap(bridgeGame.currentMoving, judgeMoving())
    }

    private fun judgeMoving(): Boolean {
        return bridgeGame.judgeMovingSuccess()
    }
}