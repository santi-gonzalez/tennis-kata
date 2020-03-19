class TennisGame1 : TennisGame {
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
            anyScoreIsMoreThanFour() -> mapDifferenceScore()
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

    private fun mapDifferenceScore(): String = when {
        isPlayer1Advantage() -> "Advantage player1"
        isPlayer2Advantage() -> "Advantage player2"
        isPlayer1Won() -> "Win for player1"
        else -> "Win for player2"
    }

    private fun isPlayer1Advantage() = player1Score - player2Score == 1

    private fun isPlayer2Advantage() = player1Score - player2Score == -1

    private fun isPlayer1Won() = player1Score - player2Score >= 2

    private fun mapEqualScore(): String = when (player1Score) {
        0 -> "Love-All"
        1 -> "Fifteen-All"
        2 -> "Thirty-All"
        else -> "Deuce"
    }
}
