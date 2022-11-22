package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest

class BridgeRandomNumberGeneratorTest {
    private lateinit var bridgeRandomNumberGenerator: BridgeNumberGenerator

    @BeforeEach
    fun setUp() {
        bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    }

    @RepeatedTest(value = 10)
    fun `0 또는 1의 랜덤 숫자만 생성하는지 테스트`() {
        val randomNumber = bridgeRandomNumberGenerator.generate()
        Assertions.assertThat(randomNumber == 0 || randomNumber == 1).isEqualTo(true)
    }
}