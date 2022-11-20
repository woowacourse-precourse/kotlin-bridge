package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    private val bridge = BridgeView(
        BridgeMaker(BridgeRandomNumberGenerator()),
        InputView(),
        OutputView()
    )

    fun start() {
        bridge.initBridge()
    }

    fun move(){
        while (!bridge.getGameIsEnd()){
            bridge.checkPlayerCanMove()
        }
    }

    fun retry() : Boolean {
        return bridge.checkRestart()
    }

    fun end(){
        bridge.finalResult()
    }
}
