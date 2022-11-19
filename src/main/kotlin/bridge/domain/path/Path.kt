package bridge.domain.path

import bridge.util.DOWN_INDEX
import bridge.util.UP
import bridge.util.UP_INDEX

class Path(private val path: List<String> = emptyList()) {
    /**
     * @param newDirection 새로 추가 될 이동 방향
     * @return 경로를 추가하여 새로운 일급 컬렉션 객체 반환
     * */
    fun createNewPath(newDirection: String): Path {
        val newPath = ArrayList(path)
        newPath.add(newDirection)
        return Path(newPath)
    }

    /**
     * @return 진행 중인 라운드 반환
     * */
    fun position(): Int = path.size - 1

    fun userDirectionOf(index: Int): String = path[index]

    fun userDirectionAsDigit(index: Int): Int = userDirectionOf(index).convertDigit()

    fun checkDirection(direction: String, round: Int): Boolean = direction == path[round]

    private fun String.convertDigit(): Int {
        if (this == UP) {
            return UP_INDEX
        }
        return DOWN_INDEX
    }
}