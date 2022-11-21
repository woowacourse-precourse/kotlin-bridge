package bridge

import constant.Message
import constant.Symbol

class BridgeGame(val bridge: List<String>) {

    private val up = mutableListOf<String>()
    private val down = mutableListOf<String>()
    private var attempts = 1

    init {
        move()
    }

    private fun move() {
        for (i in bridge.indices) {
            val success = calcResult()
            OutputView().printMap(up, down)
            if (!success) {
                checkRetry()
                return Unit
            }
        }
        end()
    }

    private fun calcResult(): Boolean {
        val moving = InputView().readMoving()
        if (moving == Symbol.UP.symbol) {
            return calcUpResult(moving)
        }
        return calcDownResult(moving)
    }

    private fun calcUpResult(moving: String): Boolean {
        down.add(Symbol.NOTHING.symbol)
        if (bridge[up.size] == moving) {
            up.add(Symbol.SUCCESS.symbol)
            return true
        }
        up.add(Symbol.FAIL.symbol)
        return false
    }

    private fun calcDownResult(moving: String): Boolean {
        up.add(Symbol.NOTHING.symbol)
        if (bridge[down.size] == moving) {
            down.add(Symbol.SUCCESS.symbol)
            return true
        }
        down.add(Symbol.FAIL.symbol)
        return false
    }

    private fun checkRetry() {
        val retry = InputView().readGameCommand()
        if (retry == Symbol.RETRY.symbol) retry()
        else quit()
    }

    private fun retry() {
        up.clear()
        down.clear()
        attempts++
        move()
    }

    private fun quit() {
        OutputView().printResult(up, down)
        OutputView().printSuccessResult(Message.FAIL.message, attempts)
    }

    private fun end() {
        OutputView().printResult(up, down)
        OutputView().printSuccessResult(Message.SUCCESS.message, attempts)
    }
}
