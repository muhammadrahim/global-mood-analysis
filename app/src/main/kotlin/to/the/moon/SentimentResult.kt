package to.the.moon

class SentimentResult(var sentimentType: String? = null, var sentimentScore: Int = 0,
                      var sentimentClass: SentimentClassification? = null
) {
    override fun toString(): String {
        return "SentimentResult(sentimentType=$sentimentType," +
                " sentimentScore=$sentimentScore," +
                " sentimentClassWeights=${sentimentClass!!.veryNegative}, ${sentimentClass!!.negative}, " +
                "${sentimentClass!!.neutral}, ${sentimentClass!!.positive}, ${sentimentClass!!.veryPositive})"
    }
}
