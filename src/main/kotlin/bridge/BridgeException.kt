package bridge


class BridgeException (private val inp: String?) {

    fun toBridgeSize(): Int {
        if (inp.isNullOrBlank()) throw IllegalArgumentException()
        val bridgeSize = inp.toInt()
        if (bridgeSize !in 3..20) throw IllegalArgumentException()
        return bridgeSize
    }

}