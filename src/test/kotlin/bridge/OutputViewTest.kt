//package bridge
//
//import bridge.view.OutputView
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.TestInstance
//import org.junit.jupiter.params.ParameterizedTest
//import org.junit.jupiter.params.provider.Arguments
//import org.junit.jupiter.params.provider.MethodSource
//import java.io.ByteArrayInputStream
//import java.io.ByteArrayOutputStream
//import java.io.InputStream
//import java.io.PrintStream
//import java.util.stream.Stream
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class OutputViewTest {
//    private lateinit var outputView: OutputView
//    private lateinit var out: ByteArrayOutputStream
//    private val expected = "[ O | O |   ]\n[   |   | X ]\n"
//
//    @BeforeEach
//    fun setUp() {
//        outputView = OutputView()
//        out = ByteArrayOutputStream()
//        System.setOut(PrintStream(out))
//    }
//
//    @ParameterizedTest
//    @MethodSource("generateMap")
//    fun `특정 경로에 대해 올바른 형식으로 경로를 출력할 수 있는가?`(notFormattedMap: Array<String>) {
//        outputView.printMap(notFormattedMap)
//        assertThat(expected).isEqualTo(out.toString())
//    }
//
//    private fun generateMap(): Stream<Arguments> {
//        return Stream.of(
//            Arguments.of(arrayOf("[   ][   ][ X ]", "[ O ][ O ][   ]"))
//        )
//    }
//
//
//}