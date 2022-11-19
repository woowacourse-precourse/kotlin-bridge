package bridge

import ui.InputView

/**
 * 다리 건너기 게임의 진행을 관리하는 클래스
 */
class BridgeGameController {
    private val inputView: InputView = InputView()
    private val bridgeGame: BridgeGame = BridgeGame()

    fun runGame() {
        setGameInfoInit()

        while (bridgeGame.getMoveCount() < bridgeGame.getBridgeSize()) {
            println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
            bridgeGame.move(inputView.readMoving())
            // todo print 게임 진행 상황
            println()
            if(!bridgeGame.isSuccess()) break
        }

        // todo 최종 게임 결과 [...] [...]

        if(bridgeGame.isSuccess()) println("게임 성공 여부: 성공")
        else println("게임 성공 여부: 실패")
        println("총 시도한 횟수: ${bridgeGame.getTryCount()}")

    }

    private fun setGameInfoInit() {
        println("다리 건너기 게임을 시작합니다.")
        println()
        println("다리의 길이를 입력해주세요.")
        println()

        bridgeGame.setBridgeSize(inputView.readBridgeSize())
        bridgeGame.setBridge(BridgeMaker(BridgeRandomNumberGenerator()))
    }

}