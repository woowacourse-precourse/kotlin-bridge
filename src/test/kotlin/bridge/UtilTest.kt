package bridge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UtilTest {
    val util = Util()
    @Test
    fun isIntTest(){
        assertThat(util.isInt("123")).isEqualTo(true)
        assertThat(util.isInt("abc")).isEqualTo(false)
    }
    @Test
    fun isInRangeTest(){
        assertThat(util.isInRange(12)).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            util.isInRange(33)
        }
    }
    @Test
    fun isUDTest(){
        assertThat(util.isUD("U")).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            util.isRQ("C")
        }
    }
    @Test
    fun isRQTest(){
        assertThat(util.isRQ("R")).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            util.isRQ("D")
        }
    }
}