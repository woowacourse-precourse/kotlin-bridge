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
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            assertThat(bridgeGame.bridge).containsExactly("U", "D", "D")
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["U"])
    @DisplayName("Move 테스트 성공 U, 0")
    fun `BridgeGame Move success U 0`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index) }
            assertThat(bridgeGame.getCurBridge()).isEqualTo(Pair("[ O ]","[   ]"))
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["D"])
    @DisplayName("Move 테스트 실패 D, 0")
    fun `BridgeGame Move fail D 0`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
            assertThat(bridgeGame.getCurBridge()).isEqualTo(Pair("[   ]","[ X ]"))
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["a"])
    @DisplayName("Move 테스트 예외 a, 0")
    fun `BridgeGame Move exception a 0`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
            assertThat(bridgeGame.getCurBridge()).isEqualTo(Pair("[","["))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["UD"])
    @DisplayName("Move 테스트 성공 UD, 1")
    fun `BridgeGame Move success UD 1`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
            assertThat(bridgeGame.getCurBridge()).isEqualTo(Pair("[ O |   ]","[   | O ]"))
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["UU"])
    @DisplayName("Move 테스트 실패 UU, 1")
    fun `BridgeGame Move fail UU 1`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
            assertThat(bridgeGame.getCurBridge()).isEqualTo(Pair("[ O | X ]","[   |   ]"))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["U"])
    @DisplayName("isFailed 테스트 not fail")
    fun `BridgeGame isFailed not fail`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
            assertThat(bridgeGame.isFailed()).isEqualTo(false)
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["D"])
    @DisplayName("isFailed 테스트 fail second")
    fun `BridgeGame isFailed fail second`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
            assertThat(bridgeGame.isFailed()).isEqualTo(true)
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["UU"])
    @DisplayName("isFailed 테스트 fail first")
    fun `BridgeGame isFailed fail first`(Moving: String) {
        assertSimpleTest {
            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
            Moving.forEachIndexed { index, it -> bridgeGame.move(it.toString(), index)}
            assertThat(bridgeGame.isFailed()).isEqualTo(true)
        }
    }

//    @ParameterizedTest
//    @ValueSource(strings = ["UU"])
//    @DisplayName("isFailed 테스트 fail first")
//    fun `BridgeGame isFailed fail first`(Moving: String) {
//        assertSimpleTest {
//            val numberGenerator: BridgeNumberGenerator = TestNumberGenerator(listOf(1, 0, 0))
//            val bridgeGame = BridgeGame(BridgeMaker(numberGenerator),3)
//            var curBridge = Pair("[","[")
//            Moving.forEachIndexed { index, it ->
//                curBridge = bridgeGame.move(curBridge, it.toString(), index)
//            }
//
//            if (curBridge == Pair("[ O | X ]","[   |   ]") && bridgeGame.isFailed(curBridge) && curBridge.first.contains
//                    (MOVE_WRONG))
//                println("성공")
//            else {
//                println("실패")
//                println(curBridge.first)
//            }
//        }
//    }
    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
    companion object {
        private const val MOVE_CORRECT = " O "
        private const val MOVE_WRONG   = " X "
        private const val MOVE_NOT_CHOOSE = "   "
    }
}