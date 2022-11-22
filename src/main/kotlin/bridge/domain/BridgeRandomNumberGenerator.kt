package bridge.domain

import bridge.data.ONE
import bridge.data.ZERO
import camp.nextstep.edu.missionutils.Randoms

class BridgeRandomNumberGenerator : BridgeNumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE)
    }

    companion object {
        const val RANDOM_LOWER_INCLUSIVE = ZERO
        const val RANDOM_UPPER_INCLUSIVE = ONE
    }
}
