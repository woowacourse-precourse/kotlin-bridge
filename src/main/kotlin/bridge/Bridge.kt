package bridge

class Bridge(private val way: MutableList<String>) {

    private val input = InputView()
    private val output = OutputView()

    fun move(answerWay:List<String>):Boolean {
        val choice = input.readMoving()
        way.add(choice)
        output.printMap(makeUpStep(answerWay),makeDownStep(answerWay))
        return destory(answerWay)

    }
    fun makeUpStep(answerWay: List<String>):List<String>{
        var line= mutableListOf<String>()
        for(step in way.indices){
            if(way[step]=="U"){
                line.add(compare(answerWay[step],way[step]))
            }
            if(way[step]=="D"){
                line.add(" ")
            }
        }
        return line
    }

    fun makeDownStep(answerWay: List<String>):List<String>{
        var line= mutableListOf<String>()
        for(step in way.indices){
            if(way[step]=="D"){
                line.add(compare(answerWay[step],way[step]))
            }
            if(way[step]=="U"){
                line.add(" ")
            }
        }
        return line
    }

    fun compare(answerStep:String,step:String):String{
        if(answerStep == step){
            return "O"
        }
        return "X"
    }

    fun destory(answerWay: List<String>):Boolean{
        for(step in way.indices){
            if(answerWay[step]!=way[step]){
                return false
            }
        }
        return true
    }

    fun getMyWaySize():Int{
        return way.size
    }





}