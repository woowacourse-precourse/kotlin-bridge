package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeNumberGenerator
import bridge.BridgeRandomNumberGenerator
import bridge.data.Bridge
import bridge.data.GameHistory
import bridge.data.GameResult
import java.util.*
import java.util.ArrayDeque

class BridgeGame(private val bridge: Bridge) {

    val isRunning: Boolean
        get() = (round < bridge.size) && (wrongCount == 0)

    val isCompleted: Boolean
        get() = (round == bridge.size) && (wrongCount == 0)

    val lastHistory: GameHistory
        get() = histories.peek()

    val result: GameResult
        get() = getGameResult()

    private var round = 0
    private var wrongCount = 0
    private val histories: Deque<GameHistory> = ArrayDeque(listOf(GameHistory()))

    fun move(floor: Bridge.Floor) {
        check(isRunning) { "Game is not running" }

        val isCorrect = (bridge[round++] == floor)
        if (!isCorrect) {
            wrongCount += 1
        }

        lastHistory.add(floor, isCorrect)
    }

    fun retry() {
        check(!isRunning && !isCompleted) { "Game is already running or completed" }

        round = 0
        wrongCount = 0
        histories.push(GameHistory())
    }

    private fun getGameResult(): GameResult {
        check(!isRunning) { "Game is still running" }

        return GameResult(isCompleted, histories.size, lastHistory)
    }

    class Builder {

        private var size = Bridge.SIZE_MIN
        private var generator: BridgeNumberGenerator? = null

        fun size(size: Int) = apply {
            this.size = size
        }

        fun generator(generator: BridgeNumberGenerator) = apply {
            this.generator = generator
        }

        fun build(): BridgeGame {
            val floors = BridgeMaker(generator ?: BridgeRandomNumberGenerator())
                .makeBridge(size)

            return BridgeGame(
                Bridge.newInstance(floors)
            )
        }
    }
}
