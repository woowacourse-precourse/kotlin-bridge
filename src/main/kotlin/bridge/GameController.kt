package bridge

class GameController {
    private val inputView = InputView()

    init {
        println("다리 건너기 게임을 시작합니다.")
    }

    fun gameStart() {
        inputBridgeSize()
    }

    private fun inputBridgeSize(){
        println("다리의 길이를 입력해주세요.")
        inputView.readBridgeSize()
    }
}