package bridge.data

class Bridge {

    enum class Type {
        U, D;

        companion object {
            private val names = values().map { it.name }.toSet()

            fun contains(name: String): Boolean = name.contains(name)
        }
    }

    companion object {
        const val SIZE_MIN = 3
        const val SIZE_MAX = 20

        val SizeRange = SIZE_MIN..SIZE_MAX
    }
}