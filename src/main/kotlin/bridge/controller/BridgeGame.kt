package bridge.controller

import bridge.model.BridgeMaker
import bridge.view.InputView
import bridge.view.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val bridgeMaker: BridgeMaker,
    private val outputView: OutputView,
    private val inputView: InputView,
) : App {
    private lateinit var bridge: List<String>
    private var round = 0
    private var trialCount = 1

    private fun bridgeSetUp() {
        println("다리 건너기 게임을 시작합니다.")
        val bridgeSize = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(size = bridgeSize)
    }

    override fun start() {
        bridgeSetUp()
        process()
    }

    // 게임 진행
    override fun process() {
        do {
            move()
        } while (round < bridge.size)
    }

    // 게임 종료
    override fun quit() {
        TODO("Not yet implemented")
    }

    // 게임 다시 시작
    override fun retry() {
        trialCount++
        round = 0
    }


    private fun move() {
        val moving = inputView.readMoving()

        round++
    }

}