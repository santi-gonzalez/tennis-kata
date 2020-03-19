class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var m_score1: Int = 0
    private var m_score2: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            m_score1 += 1
        else
            m_score2 += 1
    }

    override fun getScore() = when {
            scoreAreEqual() -> mapEqualScore()
            anyScoreIsMoreThanFour() -> mapDifferenceScore("")
            else -> mapScore()
        }

    private fun anyScoreIsMoreThanFour() = m_score1 >= 4 || m_score2 >= 4

    private fun scoreAreEqual() = m_score1 == m_score2

    private fun mapScore(): String = addScoreName(m_score1) + "-" + addScoreName(m_score2)

    private fun addScoreName(playerScore: Int): String = when (playerScore) {
        0 -> "Love"
        1 -> "Fifteen"
        2 -> "Thirty"
        3 -> "Forty"
        else -> ""
    }

    private fun mapDifferenceScore(score: String): String {
        var score1 = score
        val minusResult = m_score1 - m_score2
        score1 = when {
            minusResult == 1 -> "Advantage player1"
            minusResult == -1 -> "Advantage player2"
            minusResult >= 2 -> "Win for player1"
            else -> "Win for player2"
        }
        return score1
    }

    private fun mapEqualScore(): String {
        return when (m_score1) {
            0 -> "Love-All"
            1 -> "Fifteen-All"
            2 -> "Thirty-All"
            else -> "Deuce"
        }
    }
}
