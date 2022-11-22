package bridge

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BridgeGameTest : NsTest() {
    @Nested
    inner class `다리 길이 입력값 유효성 검사` {
        @Test
        fun `사용자가 정상적으로 입력한 경우`() {
            val inputNumber = "10"
            assertTrue(InputValidator(inputNumber).checkBridgeLengthException())
        }

        @Test
        fun `사용자의 입력값에 특수문자가 포함된 경우`() {
            val inputNumber = "10-"
            assertThrows<IllegalArgumentException> {
                InputValidator(inputNumber).checkBridgeLengthException()
            }
        }
        @Test
        fun `사용자의 입력값에 문자가 포함된 경우`() {
            val inputNumber = "10k"
            assertThrows<IllegalArgumentException> {
                InputValidator(inputNumber).checkBridgeLengthException()
            }
        }

        @Test
        fun `사용자의 입력값이 허용범위보다 큰 경우`() {
            val inputNumber = "23"
            assertThrows<IllegalArgumentException> {
                InputValidator(inputNumber).checkBridgeLengthException()
            }
        }

        @Test
        fun `사용자의 입력값에 허용범위보다 작은 경우`() {
            val inputNumber = "2"
            assertThrows<IllegalArgumentException> {
                InputValidator(inputNumber).checkBridgeLengthException()
            }
        }
    }

    @Nested
    inner class `다리 생성` {
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

        @Test
        fun `입력값만큼 다리를 생성`() {
            val bridgeLength = "5"
            assertTrue(bridgeMaker.makeBridge(bridgeLength.toInt()).size == bridgeLength.toInt())
        }

        @Test
        fun `1은 U로, 0은 D로 리스트 재구성`() {
            val testBridge = listOf(1, 0, 1, 1)
            val convertBridge: MutableList<String> = mutableListOf()
            for (element in testBridge) {
                convertBridge.add(bridgeMaker.judgeUpOrDown(element))
            }
            assertTrue(convertBridge == listOf("U", "D", "U", "U"))
        }
    }

    @Nested
    inner class `사용자가 이동할 칸 선택` {
        @Test
        fun `사용자가 대문자 U를 정상적으로 입력한 경우`() {
            val inputDirection = "U"
            assertTrue(InputValidator(inputDirection).checkDirectionException())
        }

        @Test
        fun `사용자가 대문자 D를 정상적으로 입력한 경우`() {
            val inputDirection = "D"
            assertTrue(InputValidator(inputDirection).checkDirectionException())
        }

        @Test
        fun `사용자의 입력값에 숫자가 포함된 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidator("U8").checkDirectionException()
            }
        }

        @Test
        fun `사용자의 입력값에 특수문자가 포함된 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidator("U*").checkDirectionException()
            }
        }

        @Test
        fun `사용자의 입력값이 소문자 u인 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidator("u").checkDirectionException()
            }
        }

        @Test
        fun `사용자의 입력값이 대문자 U, D가 아닌 다른 대문자인 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidator("I").checkDirectionException()
            }
        }
    }

    @Nested
    inner class `사용자가 선택한 칸이 건널 수 있는 칸인지 판정` {
        @Test
        fun `사용자가 건널 수 있는 윗칸을 선택한 경우`() {
            val inputDirection = "U"
            val square = "U"
            assertTrue(BridgeGame().move(inputDirection, square))
        }

        @Test
        fun `사용자가 건널 수 있는 아랫칸을 선택한 경우`() {
            val inputDirection = "D"
            val square = "D"
            assertTrue(BridgeGame().move(inputDirection, square))
        }

        @Test
        fun `사용자가 건널 수 없는 윗칸을 선택한 경우`() {
            val inputDirection = "U"
            val square = "D"
            assertFalse(BridgeGame().move(inputDirection, square))
        }

        @Test
        fun `사용자가 건널 수 없는 아랫칸을 선택한 경우`() {
            val inputDirection = "D"
            val square = "U"
            assertFalse(BridgeGame().move(inputDirection, square))
        }
    }

    @Nested
    inner class `사용자의 의사에 따른 재시도 또는 종료 입력값 유효성 검사` {
        @Test
        fun `사용자가 대문자 R를 정상적으로 입력한 경우`() {
            val inputDirection = "R"
            assertTrue(InputValidator(inputDirection).checkRestartOrQuitException())
        }

        @Test
        fun `사용자가 대문자 Q를 정상적으로 입력한 경우`() {
            val inputDirection = "Q"
            assertTrue(InputValidator(inputDirection).checkRestartOrQuitException())
        }

        @Test
        fun `사용자의 입력값에 숫자가 포함된 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidator("Q2").checkRestartOrQuitException()
            }
        }

        @Test
        fun `사용자의 입력값에 특수문자가 포함된 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidator("R$").checkRestartOrQuitException()
            }
        }

        @Test
        fun `사용자의 입력값이 소문자 r인 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidator("r").checkRestartOrQuitException()
            }
        }

        @Test
        fun `사용자의 입력값이 대문자 R, Q가 아닌 다른 대문자인 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidator("U").checkRestartOrQuitException()
            }
        }
    }

    @Nested
    inner class `사용자의 방향 입력값에 따른 OX 표시와 성공실패 여부` {
        private var success = true
        private val computerBridge = listOf("U", "D", "U", "U")
        private val userInputBridge1 = listOf("U", "D", "U", "U")
        private val userInputBridge2 = listOf("U", "U", "U", "U")

        @Test
        fun `게임 성공`() {
            val bridgeGame = BridgeGame()
            for (i in computerBridge.indices) {
                success = bridgeGame.move(userInputBridge1[i], computerBridge[i])
                if (!success) break
            }
            assertTrue(bridgeGame.upResult == listOf(" O ", "   ", " O ", " O "))
            assertTrue(bridgeGame.downResult == listOf("   ", " O ", "   ", "   "))
            assertTrue(success)
        }

        @Test
        fun `게임 실패`() {
            val bridgeGame = BridgeGame()
            for (i in computerBridge.indices) {
                success = bridgeGame.move(userInputBridge2[i], computerBridge[i])
                if (!success) break
            }
            assertTrue(bridgeGame.upResult == listOf(" O ", " X "))
            assertTrue(bridgeGame.downResult == listOf("   ", "   "))
            assertFalse(success)
        }


    }

    override fun runMain() {
        main()
    }

}