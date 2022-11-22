package bridge.domain.validator

import bridge.data.InputError
import bridge.data.InputDataSource.gameCommand
import bridge.ui.Views
import java.lang.IllegalArgumentException

class ValidateGameCommand(
    private val views: Views = Views(),
) {
    operator fun invoke() {
        do {
            try {
                views.inputView.readGameCommand().apply {
                    require(isRetryOrQuit())
                    gameCommand = this
                }
            } catch (exception: IllegalArgumentException) {
                views.outputView.printError(InputError.GameCommandInputError(RETRY_OR_QUIT_EXCEPTION))
            }
        } while (gameCommand.isEmpty())
    }

    private fun String.isRetryOrQuit(): Boolean {
        return (this == RETRY_CHARACTER) || (this == QUIT_CHARACTER)
    }

    companion object {
        const val RETRY_CHARACTER = "R"
        const val QUIT_CHARACTER = "Q"
        const val RETRY_OR_QUIT_EXCEPTION = "게임을 다시 시작할지 여부는 R(재시작)과 Q(종료) 중 하나의 문자만 입력해야 합니다."
    }
}