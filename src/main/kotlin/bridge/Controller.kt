package bridge

class Controller {
    /**
     * 필요 클래스 생성 및 게임 시작
     */
    fun play() {
        try {
            InputView().readBridgeSize()
            InputView().readMoving()
            InputView().readGameCommand()
        } catch (e: IllegalArgumentException) {
            print(e)
        }
    }
}