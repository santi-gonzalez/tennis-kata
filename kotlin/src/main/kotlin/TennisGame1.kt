class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var player1Score: Int = 0
    private var player2Score: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            player1Score += 1
        else
            player2Score += 1
    }

    override fun getScore() = when {
            scoreAreEqual() -> mapEqualScore()
            anyScoreIsMoreThanFour() -> mapDifferenceScore("")
            else -> mapScore()
        }

    private fun anyScoreIsMoreThanFour() = player1Score >= 4 || player2Score >= 4

    private fun scoreAreEqual() = player1Score == player2Score

    private fun mapScore(): String = addScoreName(player1Score) + "-" + addScoreName(player2Score)

    private fun addScoreName(playerScore: Int): String = when (playerScore) {
        0 -> "Love"
        1 -> "Fifteen"
        2 -> "Thirty"
        3 -> "Forty"
        else -> ""
    }

    private fun mapDifferenceScore(score: String): String {
        var score1 = score
        val minusResult = player1Score - player2Score
        score1 = when {
            minusResult == 1 -> "Advantage player1"
            minusResult == -1 -> "Advantage player2"
            minusResult >= 2 -> "Win for player1"
            else -> "Win for player2"
        }
        return score1
    }

    private fun mapEqualScore(): String {
        return when (player1Score) {
            0 -> "Love-All"
            1 -> "Fifteen-All"
            2 -> "Thirty-All"
            else -> "Deuce"
        }
    }
}
