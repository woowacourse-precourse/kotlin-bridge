package bridge.domain

import bridge.main
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test

class BridgeUserInputTest: NsTest() {
    @Test
    fun `유저 입력 테스트 1, 실패하는 경우 R 입력시 재시작`() {
    }

    @Test
    fun `유저 입력 테스트 2, 실패하는 경우 Q 입력시 종료`() {
    }

    @Test
    fun `유저 입력 테스트 3, 실패하는 경우 R과 Q 이외 입력시 예외처리`() {
    }

    @Test
    fun `유저 입력 테스트 4, 다음 칸 입력하는 경우, U와 D이외 입력시 예외처리`() {
    }

    override fun runMain() {
        main()
    }
}