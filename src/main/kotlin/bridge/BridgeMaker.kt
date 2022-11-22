package bridge

import org.mockito.internal.matchers.Null

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

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
