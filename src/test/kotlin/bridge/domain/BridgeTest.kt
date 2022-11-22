package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class BridgeTest {
    private lateinit var bridge: Bridge

    @BeforeEach
    fun setUp() {
        bridge = Bridge(mutableListOf("O", " ", "O"))
    }

    @DisplayName("get 메소드가 제대로 값을 불러오는지 확인")
    @ParameterizedTest
    @CsvSource("0,O", "1,' '", "2,O")
    fun get(index: Int, value: String) {
        assertThat(bridge.get(index)).isEqualTo(value)
    }

    @Test
    fun testToString() {
        assertThat(bridge.toString()).isEqualTo("[ O |   | O ]")
    }

    @DisplayName("setWrongAnswer 메소드가 잘못된 값을 넣어 제대로 반환하는지 확인")
    @ParameterizedTest
    @CsvSource("0,' ',[   ]", "1,X,[ O | X ]", "2,X,[ O |   | X ]", "2,' ',[ O |   |   ]")
    fun setWrongAnswer(position: Int, xOrEmpty: String, expected: String) {
        assertThat(bridge.getWrongAnswerBridge(position, xOrEmpty).toString()).isEqualTo(expected)
    }

    @DisplayName("subBridge 메소드가 의도한 범위대로 반환하는지 확인")
    @ParameterizedTest
    @CsvSource("0,[ O ]", "1,[ O |   ]", "2,[ O |   | O ]")
    fun subBridge(position: Int, expected: String) {
        assertThat(bridge.getNowBridge(position).toString()).isEqualTo(expected)
    }
}