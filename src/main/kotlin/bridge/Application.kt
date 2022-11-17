package bridge

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("다리 건너기 게임을 시작합니다.")
    var inputview = InputView()
    var outputview = OutputView()
    var bridgegame = BridgeGame()
    var size = inputview.readBridgeSize()
    var bridgeNumberGenerator = BridgeRandomNumberGenerator()
    var bridgemaker = BridgeMaker(bridgeNumberGenerator)
    var makeBridge = bridgemaker.makeBridge(size)
    var i = 0
    var count=0
    while(i < size)
    {
        bridgegame.move()
        if (bridgegame.userselectupdown[i] == makeBridge[i])
        {
            outputview.printMap(bridgegame.userselectupdown , i+1)
            i++
        }
        else
        {
            var checkretry = inputview.readGameCommand()
            if (checkretry == "R")
            {
                bridgegame.userselectupdown.clear()
                i = 0
                count+=1
            }
            else if (checkretry == "Q")
            {
                println("종료합니다.")
                break
            }
        }

    }
    println("최종 게임 결과")
    outputview.printMap(makeBridge,size)
    println("총 시도한 횟수: ${count}")


}
