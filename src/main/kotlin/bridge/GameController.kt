package bridge

import bridge.view.InputView
import bridge.view.OutputView

class GameController {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()

    init {
        println("다리 건너기 게임을 시작합니다.")
    }

    fun gameStart() {
        makeBridge(inputBridgeSize())
        repeatMoving()
        // check isSuccess than question restart
    }

    private fun inputBridgeSize() : Int{
        println("다리의 길이를 입력해주세요.")
        return inputView.readBridgeSize()
    }

    private fun makeBridge(size : Int){
        bridgeGame.createCorrectBridgeMap(size)
    }

    private fun repeatMoving(){
        while(true){
            //checkFinish by BridgeGame.compare return pair(isSuccess / isStop)
            // than this function return isSuccess
            moving()
        }
    }
    private fun moving(){
        bridgeGame.move(inputMoving())
    }

    private fun inputMoving() : String{
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        return inputView.readMoving()
    }

    private fun judgeMoving() : Boolean{
        return bridgeGame.judgeMovingSuccess()
    }
}