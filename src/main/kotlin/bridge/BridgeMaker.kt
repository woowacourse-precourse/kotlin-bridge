package bridge

import org.mockito.internal.matchers.Null

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        var makemapp = MutableList<Any>(size) {0}
        for (i in 0..size-1 step 1){
            makemapp[i] = bridgeNumberGenerator.generate()
            if(makemapp[i] == 1) makemapp[i] = 'U'
            if(makemapp[i] == 0) makemapp[i] = 'D'
        }
        return (makemapp.toList().map {it.toString()})
//        var mapp : MutableList<Pair<Int, Int>> = mutableListOf()
//        for (i in 0..size step 1)
//            mapp += Pair(bridgeNumberGenerator.generate(), bridgeNumberGenerator.generate())
//
//       return mapp.toList().map { it.toString() }


    }
}
