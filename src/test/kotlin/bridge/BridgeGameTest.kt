package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BrigeGameTest {
    @Test
    @DisplayName("다리 생성 테스트")
    fun `BridgeGame normal 3`() {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            if (BridgeGame(BridgeMaker(numberGenerator),3).bridge == (listOf("U", "D", "D")))
                println("성공")
            else {
                println("실패")
                println(BridgeGame(BridgeMaker(numberGenerator),3).bridge)
            }
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["U"])
    @DisplayName("Move 테스트 성공 U, 0")
    fun `BridgeGame Move success U 0`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            var curBridge = Pair("[","[")
            Moving.forEachIndexed { index, it ->
                curBridge = bridgeGame.move(curBridge, it.toString(), index)
            }

            if (curBridge == Pair("[ O ]","[   ]"))
                println("성공")
            else {
                println("실패")
                println(curBridge)
            }
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["D"])
    @DisplayName("Move 테스트 실패 D, 0")
    fun `BridgeGame Move fail D 0`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            var curBridge = Pair("[","[")
            Moving.forEachIndexed { index, it ->
                curBridge = bridgeGame.move(curBridge, it.toString(), index)
            }

            if (curBridge == Pair("[   ]","[ X ]"))
                println("성공")
            else {
                println("실패")
                println(curBridge)
            }
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["a"])
    @DisplayName("Move 테스트 예외 a, 0")
    fun `BridgeGame Move exception a 0`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            var curBridge = Pair("[","[")
            Moving.forEachIndexed { index, it ->
                curBridge = bridgeGame.move(curBridge, it.toString(), index)
            }

            if (curBridge ==  Pair("[ X ]","[ X ]"))
                println("성공")
            else {
                println("실패")
                println(curBridge)
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["UD"])
    @DisplayName("Move 테스트 성공 UD, 1")
    fun `BridgeGame Move success UD 1`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            var curBridge = Pair("[","[")
            Moving.forEachIndexed { index, it ->
                curBridge = bridgeGame.move(curBridge, it.toString(), index)
            }

            if (curBridge == Pair("[ O |   ]","[   | O ]"))
                println("성공")
            else {
                println("실패")
                println(curBridge)
            }
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["UU"])
    @DisplayName("Move 테스트 실패 UU, 1")
    fun `BridgeGame Move fail UU 1`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            var curBridge = Pair("[","[")
            Moving.forEachIndexed { index, it ->
                curBridge = bridgeGame.move(curBridge, it.toString(), index)
            }

            if (curBridge == Pair("[ O | X ]","[   |   ]"))
                println("성공")
            else {
                println("실패")
                println(curBridge)
            }
        }
    }
    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}