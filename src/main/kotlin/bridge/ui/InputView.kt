package bridge.ui

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): String {
        return inputValue()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return inputValue()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return inputValue()
    }

    /**
     * @author onseok
     * 사용자의 입력을 담당하는 함수입니다.
     */
    private fun inputValue(): String = Console.readLine()

    /**
     * @author onseok
     * 사용자가 콘솔에 입력하기 전 입력 사항에 대한 가이드라인 역할을 하는 문구 관련 상수값들입니다.
     */
    companion object {
        const val INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요."
        const val INPUT_UP_OR_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val INPUT_RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    }
}
