package bridge.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test



internal class BridgeMapTest{
    @Test fun `clearTest_함수 실행시_필드 초기화`(){
        val bridgeMap = BridgeMap()
        bridgeMap.upSide = "test"
        val result = ""
        bridgeMap.clear()
        assertThat(result).isEqualTo(bridgeMap.upSide)
    }
}

