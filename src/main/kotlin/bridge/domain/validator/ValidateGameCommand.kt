package bridge.domain.validator

import bridge.data.InputDataSource.gameCommand

class ValidateGameCommand {
    operator fun invoke(inputValue: String) {
        inputValue.apply {
            require(isRetryOrQuit())
            gameCommand = this
        }
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