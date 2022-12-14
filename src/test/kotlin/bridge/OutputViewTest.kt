package bridge

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OutputViewTest {

    @Test
    fun `입력받은 다리 길이만큼 다리가 생성되었다`() {
//        println(OutputView().printMap(listOf("O", ""), listOf("", "O")).toString())
        Assertions.assertThat(OutputView().printMap(listOf("O", ""), listOf("", "O"))).isEqualTo(println("1"))
    }
}
