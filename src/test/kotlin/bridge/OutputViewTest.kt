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
    fun printMapTest(){
        assertThat(ov.printMap(listOf(1,0,1,0), listOf(1,0,1,0))).isEqualTo("[ O |   | O |   ]\n[   | O |   | O ]")
        assertThat(ov.printMap(listOf(1,1), listOf(1,1))).isEqualTo("[ O | O ]\n[   |   ]")
        assertThat(ov.printMap(listOf(1,0,1,0), listOf(1,0,1,1))).isEqualTo("[ O |   | O | X ]\n[   | O |   |   ]")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() :String{}
}