package bridge

import bridge.controller.BridgeGameController

fun main() {
    // TODO: 프로그램 구현
    val bridgeGame = BridgeGameController()
    println("다리 건너기 게임을 시작합니다.")
    bridgeGame.start()
}
