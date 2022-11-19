package bridge.domain.counter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TryCounterTest {

    lateinit var tryCounter: TryCounter

    @BeforeEach
    fun setUp(){
        tryCounter = TryCounter()
    }

    @Test
    fun `최초 생성시 0을 지니고 있다`() {
        val expectedResult = 0

        assertEquals(tryCounter.count(), expectedResult)
    }

    @Test
    fun `게임 시도 횟수를 증가시키는 경우`() {
        val expectedResult = 1

        tryCounter.plus()
        assertEquals(tryCounter.count(), expectedResult)
    }
}