package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.ValueSource

class OutputViewTest {

    private val ov = OutputView()
    @Test
    fun startGameTest(){
        assertThat(ov.startGame()).isEqualTo("다리 건너기 게임을 시작합니다.")
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Test
    fun printMapTest(){
        assertThat(ov.printMap("[ O |   | O |   ]\n[   | O |   | O ]\n")).isEqualTo("[ O |   | O |   ]\n[   | O |   | O ]\n")
        assertThat(ov.printMap("[ O | O ]\n[   |   ]\n")).isEqualTo("[ O | O ]\n[   |   ]\n")
        assertThat(ov.printMap("[ O |   | O | X ]\n[   | O |   |   ]\n")).isEqualTo("[ O |   | O | X ]\n[   | O |   |   ]\n")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Test
    fun printResultTest(){
        assertThat(ov.printResult(1, false, "[ O | X ]\n[   |   ]")).isEqualTo("최종 게임 결과\n[ O | X ]\n[   |   ]\n\n게임 성공 여부: 실패\n총 시도한 횟수: 1")
        assertThat(ov.printResult(2, true, "[ O |   |   ]\n[   | O | O ]")).isEqualTo("최종 게임 결과\n[ O |   |   ]\n[   | O | O ]\n\n게임 성공 여부: 성공\n총 시도한 횟수: 2")
    }
}