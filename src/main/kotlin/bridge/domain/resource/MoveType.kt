package bridge.domain.resource

enum class MoveType(
    val code: String
) {
    UP(MOVE_UP),
    DOWN(MOVE_DOWN);

    companion object {
        fun getMap(type: MoveType, path: List<String>, bridge: List<String>): List<String> {
            val map = mutableListOf<String>()
            for (i in path.indices) {
                map.add(
                    when {
                        path[i] != type.code -> NOT_MOVE
                        path[i] == bridge[i] -> MOVE_SUCCESS
                        else -> MOVE_FAIL
                    })
            }
            return map
        }
    }
}