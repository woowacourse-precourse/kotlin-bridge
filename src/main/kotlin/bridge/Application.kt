package bridge

import camp.nextstep.edu.missionutils.Console
import java.lang.Exception


var count = 1
var sucess = true
var inputview = InputView()
var outputview = OutputView()
var bridgegame = BridgeGame()
var bridgeNumberGenerator = BridgeRandomNumberGenerator()
var bridgemaker = BridgeMaker(bridgeNumberGenerator)



fun main() {
    try {
        var size = inputview.readBridgeSize()
        var makeBridge = bridgemaker.makeBridge(size)
        println("다리 건너기 게임을 시작합니다.")
        bridgegame(size,makeBridge)
        endprint(makeBridge,size)
    } catch (e : Exception){
        e.printStackTrace()
    }
}



fun bridgegamejud(i : Int) : Int {
    var checkretry = inputview.readGameCommand()
    if (checkretry == "R"){
        bridgegame.retry()
        return 0 }
    else if (checkretry == "Q") {
        println("종료합니다.")
        sucess = false
    }
    return i
}

fun bridgegame(size : Int, makeBridge : List<String>) {
    var i = 0
    while(i < size) {
        bridgegame.move(inputview.readMoving())
        if (bridgegame.userselectupdown[i] == makeBridge[i]){
            outputview.printMap(bridgegame.userselectupdown,++i) }
        else {
            outputview.printfail(bridgegame.userselectupdown,++i)
            var ivalue = bridgegamejud(i)
            i=ivalue }
        if (sucess == false) break }
}

fun endprint(a: List<String>,b: Int) {
    println("최종 게임 결과")
    var outputview = OutputView()
    outputview.printMap(a,b)
    if (sucess == true){
        println("\n게임 성공 여부: 성공")
    }
    else println("\n게임 성공 여부: 실패")
    println("총 시도한 횟수: ${count}")
}







