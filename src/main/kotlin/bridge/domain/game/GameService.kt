package bridge.domain.game

interface GameService {
    fun play()
    fun move()
    fun retry()
    fun end()
}