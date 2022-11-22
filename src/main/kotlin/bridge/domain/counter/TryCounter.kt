package bridge.domain.counter

/**
 * @param count 다리 건너기 시도 횟수
 * */
class TryCounter(private var count: Int = 0) {
    fun plus(): Int = ++count

    fun minus(): Int = --count

    fun count(): Int = count
}