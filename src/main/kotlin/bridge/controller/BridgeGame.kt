package bridge.controller

import bridge.domain.Path
import bridge.presentation.InputView
import bridge.presentation.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val inputView: InputView by lazy { InputView() }
    private val outputView: OutputView by lazy { OutputView() }

    private var path = Path()

    fun retry() {

    }

    private fun move() {
        outputView.printDirectionQuestion()
        path = path.createNewPath(inputView.readDirection())
    }
}