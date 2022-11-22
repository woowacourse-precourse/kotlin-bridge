package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest

class BridgeTest : NsTest() {
    @Test
    fun `최종결과 테스트`(){
        var bridge = listOf("D","D","D")
        var bridgeGame  = BridgeGame(mutableListOf("D","D","D"),3,0)
        bridgeGame.finalStage(bridge)
        assertThat(output()).contains(
            "[   |   |   ]",
            "[ O | O | O ]",
            "게임 성공 여부: 성공",
            "총 시도한 횟수: 3")
    }
    @Test
    fun `게임 횟수 테스트`(){
        var bridgeGame  = BridgeGame(mutableListOf("D"),3,0)
        bridgeGame.retry()
        assertThat(bridgeGame.times).isEqualTo(4)
    }

    @Test
    fun `게임 재시작 시 실패 전으로 돌아가는지 테스트`(){
        var bridgeGame  = BridgeGame(mutableListOf("U","U","U"),1,0)
        bridgeGame.retry()
        assertThat(bridgeGame.userRoute).isEqualTo(mutableListOf("U","U"))
    }

    @Test
    fun `다리 이동 판단 테스트`(){
        assertRandomNumberInRangeTest({
            run("3", "U", "U","U")
            assertThat(output()).contains(
                "다리 건너기 게임을 시작합니다.",
                "다리의 길이를 입력해주세요.",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ O ]",
                "[   ]" ,
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ O | O ]",
                "[   |   ]",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ O | O | O ]",
                "[   |   |   ]"
            )
        }, 1, 1,1)
    }

    @Test
    fun `게임 틀렸을 때 테스트`(){
        assertRandomNumberInRangeTest({
            run("4", "U", "U","D","Q")
            assertThat(output()).contains(
                "다리 건너기 게임을 시작합니다.",
                "다리의 길이를 입력해주세요.",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ O ]",
                "[   ]" ,
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ O | O ]",
                "[   |   ]",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ O | O |   ]",
                "[   |   | X ]",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
            )
        }, 1, 1,1,0)
    }

    @Test
    fun `게임 재시작 테스트`(){
        assertRandomNumberInRangeTest({
            run("3", "U", "R", "D", "U", "D")
            assertThat(output()).contains(
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ X ]",
                "[   ]" ,
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[   ]",
                "[ O ]" ,
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[   | O ]",
                "[ O |   ]",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[   | O |   ]",
                "[ O |   | O ]",
            )
        }, 0, 1,0)
    }

    override fun runMain() {
        main()
    }

}