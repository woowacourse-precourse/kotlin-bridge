package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BridgeTest {

    private val bridge = Bridge(listOf("U","D","D","U"))

    @DisplayName("유저가 움직인 칸과 다리의 칸을 비교하여 건널 수 있는 칸인지 확인하는 기능 테스트")
    @ParameterizedTest
    @CsvSource("U,0,true","U,1,false","D,2,true","D,3,false")
    fun isMatchBridgeAndUserChoice(userChoice:String,position: Int,expected:Boolean) {
        val actual =bridge.isMatchMoving(userChoice,position)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `다리의 길이가 3이하면 예외 발생`(){
        assertThrows<IllegalArgumentException> {
            Bridge(listOf("U","D"))
        }
    }

    @Test
    fun `다리의 종류가 위 또는 아래 가 아니면 예외 발생`(){
        assertThrows<IllegalArgumentException> {
            Bridge(listOf("L","D","D"))
        }
    }
}