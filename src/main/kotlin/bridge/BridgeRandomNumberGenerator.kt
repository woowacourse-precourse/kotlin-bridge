package bridge

import camp.nextstep.edu.missionutils.Randoms
//다리 ox세팅하는 함수
class BridgeRandomNumberGenerator : BridgeNumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE)
    }

    companion object {
        const val RANDOM_LOWER_INCLUSIVE = 0
        const val RANDOM_UPPER_INCLUSIVE = 1
    }
}

//typedef struct s_test {
//    int a;
//    int b;
//} t_test;
//
//int main()
//{
//    struct s_test lala;
//    lala.a =4;
//    lala.b = 2;
//}