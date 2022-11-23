package bridge.constants

import bridge.domain.game.Bridge

enum class ErrorMessage(private val message: String) {

    InvalidNumberFormat("올바른 숫자 형식이 아닙니다."),
    InvalidBridgeMoving("잘못 입력하셨습니다."),
    InvalidGameRetryCommand("잘못 입력하셨습니다."),
    OutOfBridgeSize("다리 길이는 ${Bridge.SIZE_MIN}부터 ${Bridge.SIZE_MAX} 사이의 숫자여야 합니다."),;

    override fun toString(): String = message

    companion object {
        const val PREFIX = "[ERROR]"
    }
}