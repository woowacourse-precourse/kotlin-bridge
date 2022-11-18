package bridge.domain

/**
 * @param count 다리 건너기 시도 횟수
 * */
class Counter(private var count: Int = 0) {
    fun plus(): Int {
        return ++count
    }

    fun minus(): Int {
        return --count
    }
}