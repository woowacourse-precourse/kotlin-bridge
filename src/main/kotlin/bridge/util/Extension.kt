package bridge.util

import bridge.CONNECT_PARENTHESIS
import bridge.NOT_INITIALIZED
import bridge.SUCCESSIVE_PARENTHESIS
import bridge.model.data.Direction

/**
 * 내가 커스텀한 경로의 형태를 출력 형식에 맞추기 위해서 FORMATTING 한다.
 */
fun String.formattingMap() =
    this.replace(NOT_INITIALIZED, "")
        .replace(SUCCESSIVE_PARENTHESIS, CONNECT_PARENTHESIS)


fun Int.numberToDirection() = if (this == Direction.UP.directionNumber) {
    Direction.UP.direction
} else {
    Direction.DOWN.direction
}