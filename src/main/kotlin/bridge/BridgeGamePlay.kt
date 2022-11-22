//package bridge
//
//class BridgeGamePlay: BridgeNumberGenerator {
//    val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
//    val inputView = InputView()
//    var finalAttempt = 1
//
//    override fun generate(): Int {
//        val bridgeNumber = bridgeRandomNumberGenerator.generate()
//        return bridgeNumber
//    }
//
//    fun prepare(){
//        println("다리의 길이를 입력해주세요.")
//        val bridgeSize = inputView.readBridgeSize()
//
//        // 다리 만들기
//        val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
//        val bridge = bridgeMaker.makeBridge(bridgeSize)
//        println(bridge)
//
//        playFirst(bridge, bridgeSize, 1)
//    }
//
//    fun playFirst(bridge: List<String>, bridgeSize: Int, attempt: Int){
//        var step = 0
//        var continuePlay = true
//        // 끝까지 도달했거나, 또는 X를 만났을 때
//        while (continuePlay){
//            if (finalAttempt == attempt) {
//                continuePlay = playContinue(bridge, bridgeSize, step, attempt)
//                step++
//            } else break
//        }
//    }
//
//    fun playContinue(bridge: List<String>, bridgeSize: Int, step: Int, attempt: Int): Boolean {
//        println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)")
//        val direction = inputView.readMoving()
//        display(bridge, direction, step)
//        if ( bridge[step] != direction )
//            if (!playAgain(bridge, step, attempt, bridgeSize)) return false
//        if ( step == bridge.size - 1 && finalAttempt == attempt){
//            showFinalResult(bridge, bridgeSize, "W", step, attempt)
//            return false
//        }
//        return true
//    }
//
//    fun playAgain(bridge: List<String>, step: Int, attempt: Int, bridgeSize: Int): Boolean {
//        println("\n\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
//        val gameCommand = inputView.readGameCommand()
//        if ( gameCommand == "R" ) { // 재시도
//            finalAttempt = attempt+1
//            playFirst(bridge, bridgeSize, attempt+1)
//
//        } else if (gameCommand == "Q"){ // 게임 종료
//            showFinalResult(bridge, step, gameCommand, step, attempt)
//            return false
//        }
//        return true
//    }
//
//    fun display(bridge: List<String>, direction: String, step: Int){
//        val outputView = OutputView()
//        if ( step == 0 ) outputView.printMapFirst(bridge, direction, step)
//        else outputView.printMap(bridge, direction, step)
//    }
//
//    fun showFinalResult(bridge: List<String>, bridgeSize: Int, gameCommand: String, step: Int, attempt:Int){
//        // Q - 재시도, W - 승리
//        println("\n최종 게임 결과")
//        val outputView = OutputView()
//        if ( gameCommand == "W" ) outputView.printResult(bridge, bridgeSize)
//        else if (gameCommand == "Q" ) outputView.printResultQuit(bridge, step)
//
//        print("\n\n게임 성공 여부: ")
//        if ( gameCommand == "W" ) print("성공\n") else print("실패\n")
//        println("총 시도한 횟수: $attempt")
//    }
//
//}