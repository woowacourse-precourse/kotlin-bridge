package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest {


    @Test
    fun `다리 길이에 대한 예외 테스트`(){
        assertThrows<IllegalArgumentException>{
            parseToInteger("")
        }
        assertThrows<IllegalArgumentException>{
            parseToInteger("30")
        }
        assertThrows<IllegalArgumentException>{
            parseToInteger("very long")
        }
    }

    @Test
    fun `다리 이동 예외 테스트`(){
        assertThrows<IllegalArgumentException>{
            movingCheck("d")
        }
        assertThrows<IllegalArgumentException>{
            movingCheck(" ")
        }
        assertThrows<IllegalArgumentException>{
            movingCheck("UP!")
        }
    }

    @Test
    fun `종료 예외 테스트`(){
        assertThrows<IllegalArgumentException>{
            commandCheck("종료")
        }
        assertThrows<IllegalArgumentException>{
            commandCheck("quit")
        }
        assertThrows<IllegalArgumentException>{
            commandCheck("1")
        }
    }

}