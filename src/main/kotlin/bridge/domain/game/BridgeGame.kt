package bridge.domain.game

import bridge.BridgeMaker
import bridge.BridgeNumberGenerator
import bridge.BridgeRandomNumberGenerator

class BridgeGame(private val bridge: Bridge) {

    val isRunning: Boolean get() = (state == State.Running)
    val isFailure: Boolean get() = (state == State.Failure)
    val isSuccess: Boolean get() = (state == State.Success)

    var crossingMap: BridgeCrossingMap = BridgeCrossingMap()
        private set

    private var round = 0
    private var tryCount = 1

    private var state: State = State.Running

    fun move(nextFloor: Bridge.Floor) {
        check(isRunning) { "Game is not running" }

        val isCorrect = (nextFloor == bridge[round++])

        crossingMap.add(nextFloor, isCorrect)

        if (!isCorrect) {
            state = State.Failure
        } else if (round == bridge.size) {
            state = State.Success
        }
    }

    fun retry() {
        check(isFailure) { "Game is not Failure" }

        round = 0
        tryCount += 1
        state = State.Running
        crossingMap = BridgeCrossingMap()
    }

    fun getResult(): BridgeGameResult = BridgeGameResult(isSuccess, tryCount, crossingMap)

    enum class State {
        Running, Failure, Success,
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
                .map { requireNotNull(Bridge.Floor.parse(it)) }

            return BridgeGame(Bridge(floors))
        }
    }
}
