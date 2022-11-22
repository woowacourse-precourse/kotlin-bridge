package bridge.domain.validator

import bridge.data.InputError
import bridge.data.InputDataSource.movingCommands
import bridge.ui.Views
import java.lang.IllegalArgumentException

class ValidateMoving(
    private val views: Views = Views()
) {
    operator fun invoke(inputValue: String) {
        do {
            inputValue.apply {
                require(isUpOrDown())
                movingCommands.add(this)
                views.outputView.printMap()
            }
        } while (movingCommands.size == 0)
    }

    private fun String.isUpOrDown(): Boolean {
        return (this == UP_CHARACTER) || (this == DOWN_CHARACTER)
    }

    companion object {
        const val UP_CHARACTER = "U"
        const val DOWN_CHARACTER = "D"
        const val UP_OR_DOWN_EXCEPTION = "이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력해야 합니다."
    }
}