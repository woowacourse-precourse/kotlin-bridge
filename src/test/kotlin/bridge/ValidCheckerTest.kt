package bridge

import bridge.io.ValidChecker
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.fail
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class ValidCheckerTest {
    lateinit var checker:ValidChecker
    @BeforeEach
    fun setUp(){
        checker = ValidChecker()
    }


    @Test
    fun `검사 테스트_범위1`() {
        try{
            checker.checkBridgeSize(2)
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){

        }
    }
    @Test
    fun `검사 테스트_범위2`() {
        try{
            checker.checkBridgeSize(21)
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){

        }
    }
    @Test
    fun `검사 테스트_범위3`() {
        try{
            checker.checkBridgeSize(3)

        } catch (e:IllegalArgumentException){
            fail("예외 발생하면 안되는데 발생함")
        }
    }
    @Test
    fun `검사 테스트_범위4`() {
        try{
            checker.checkBridgeSize(20)

        } catch (e:IllegalArgumentException){
            fail("예외 발생하면 안되는데 발생함")
        }
    }

    @Test
    fun `검사 테스트_UorD1`(){
        try{
            checker.checkUorD("u")
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){

        }
    }

    @Test
    fun `검사 테스트_UorD2`(){
        try{
            checker.checkUorD("d")
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){

        }
    }
    @Test
    fun `검사 테스트_UorD3`(){
        try{
            checker.checkUorD("\n")
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){

        }
    }

    @Test
    fun `검사 테스트_UorD4`(){
        try{
            checker.checkUorD("     ")
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){

        }
    }
    @Test
    fun `검사 테스트_UorD5`(){
        try{
            checker.checkUorD("한글")
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){

        }
    }

    @Test
    fun `검사 테스트_UorD6`(){
        try{
            checker.checkUorD("U")
        } catch (e:IllegalArgumentException){
            fail("예외 발생하면 안되는데 발생함")
        }
    }
    @Test
    fun `검사 테스트_UorD7`(){
        try{
            checker.checkUorD("D")
        } catch (e:IllegalArgumentException){
            fail("예외 발생하면 안되는데 발생함")
        }
    }

    @Test
    fun `검사 테스트_QorR1`(){
        Assertions.assertThat(checker.checkRorQ("R")).isTrue()
        Assertions.assertThat(checker.checkRorQ("Q")).isFalse()
    }

    @Test
    fun `검사 테스트_QorR2`(){
        try{
            checker.checkRorQ("\n")
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){
        }
    }

    @Test
    fun `검사 테스트_QorR3`(){
        try{
            checker.checkRorQ("한글")
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){
        }
    }
    @Test
    fun `검사 테스트_QorR4`(){
        try{
            checker.checkRorQ("q")
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){
        }
    }
    @Test
    fun `검사 테스트_QorR5`(){
        try{
            checker.checkRorQ("r")
            fail("예외 발생 안함")
        } catch (e:IllegalArgumentException){
        }
    }

}