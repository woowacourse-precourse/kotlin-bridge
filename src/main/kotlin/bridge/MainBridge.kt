package bridge

import bridge.enum.BridgeEnum
import bridge.presentation.InputView
import bridge.presentation.OutputView

class MainBridge {
    private val input = InputView()
    private val output = OutputView()
    private val bridgeGame: BridgeGame

    init {
        bridgeGame = bridgeSetUp()
    }

    /**
     * 게임 시작을 위한 다리 개수 입력받기
     * BridgeMaker 클래스를 통해 다리 생성하기
     */
    private fun bridgeSetUp(): BridgeGame {
        output.printStartGame()
        val bridgeSize = input.readBridgeSize()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator())
            .makeBridge(bridgeSize)
        return BridgeGame(bridge)
    }

    /**
     * 게임 상태가 실패(FAIL)일 경우, 다시 게임을 할지 입력받기
     * 게임을 계속 진행(FAIL-RETRY, CONTINUE)할 경우엔 -1 반환
     */
    private fun gameStatus(status: String): Int {
        if (status == "SUCCESS") return 1
        if (status == "FAIL") {
            output.printGameCommand()
            val restart = input.readGameCommand()
            if (restart == BridgeEnum.RESET.value) bridgeGame.retry()
            else return 0
        }
        return -1
    }

    /**
     * 게임이 성공/실패(QUIT)가 돼서 종료될때까지 반복해서 게임 시행
     * 이동할 칸을 입력받고 현재 이동한 다리 출력하는 메서드
     */
    fun bridgeGameRepeat() {
        var status = -1
        while (status < 0) {
            output.printGetMoving()
            bridgeGame.move(input.readMoving())
            output.printMap(bridgeGame)
            status = gameStatus(bridgeGame.isGameContinue())
        }
        output.printResult(bridgeGame, if (status == 1) "성공" else "실패")
    }
}