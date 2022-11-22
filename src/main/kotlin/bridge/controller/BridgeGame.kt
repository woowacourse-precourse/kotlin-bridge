package bridge.controller

import bridge.controller.processor.BridgeGameProcessor
import bridge.model.BridgeMaker
import bridge.util.Moving
import bridge.util.QUIT_COMMAND
import bridge.util.RESTART_COMMAND
import bridge.view.InputView
import bridge.view.OutputView
import com.sun.tools.javac.jvm.ByteCodes.ret

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
            moveUnable()
            finish()
        } while (round < bridge.size)
    }

    // 게임 종료
    override fun quit() {
        TODO("Not yet implemented")
    }

    // 게임 다시 시작
    override fun retry() {
        BridgeGameProcessor.deleteBridgePassInfo()
        trialCount++
        round = 0
    }

    // 라운드 이동 ( 커멘드가 U일 때 조건)
    private fun move() {
        val moving = inputView.readMoving()

        val inputMove = if (moving == "U") Moving.UP else Moving.DOWN
        val hasPassed = (moving == bridge[round])
        BridgeGameProcessor.updateBridgePassInfo(inputMove, hasPassed)

        outputView.printMap(BridgeGameProcessor.updateMapList())
        round++
    }

    // 틀렸을 때, 게임 커맨드 입력
    private fun moveUnable() {
        if (BridgeGameProcessor.updateFail()) {
            when (inputView.readGameCommand()) {
                RESTART_COMMAND -> retry()
                QUIT_COMMAND -> quit()
            }
        }
    }

    // 모든 라운드를 성공했을 때 ( 라운드와 사이즈가 같고, 틀린게 없을 때 )
    private fun finish() {
        if (round == bridge.size) {
            if (!BridgeGameProcessor.updateFail()) {
                quit()
            }
        }
    }

}