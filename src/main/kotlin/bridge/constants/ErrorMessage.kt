package bridge.constants

import bridge.domain.Bridge

enum class ErrorMessage(private val message: String) {

    InvalidNumberFormat("올바른 숫자를 입력해주세요."),
    InvalidBridgeElement("올바른 값이 아닙니다."),
    InvalidGameCommand("올바른 값이 아닙니다."),
    OutOfBridgeSize("다리 길이는 ${Bridge.SIZE_MIN}부터 ${Bridge.SIZE_MAX} 사이의 숫자여야 합니다."),;

    override fun toString(): String = message
}