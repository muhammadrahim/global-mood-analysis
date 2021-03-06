package to.the.moon.sentimentanalysis

import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations
import edu.stanford.nlp.pipeline.Annotation
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree
import edu.stanford.nlp.trees.Tree
import org.springframework.stereotype.Service
import kotlin.math.roundToInt

@Service
class SentimentAnalysisService(private val pipeline: StanfordCoreNLP) {
    fun analyse(text: String): SentimentResult = getSentimentResult(text)

    private fun getSentimentResult(text: String): SentimentResult {
        val classification = SentimentClassification()
        val sentimentResult = SentimentResult()
        if (text.isNotEmpty()) {
            val annotation: Annotation = pipeline.process(text)
            for (sentence in annotation.get(SentencesAnnotation::class.java)) {

                val tree: Tree = sentence.get(SentimentAnnotatedTree::class.java)
                val simpleMatrix = RNNCoreAnnotations.getPredictions(tree)
                classification.veryNegative = (simpleMatrix[0] * 100.0).roundToInt()
                classification.negative = (simpleMatrix[1] * 100.0).roundToInt()
                classification.neutral = (simpleMatrix[2] * 100.0).roundToInt()
                classification.positive = (simpleMatrix[3] * 100.0).roundToInt()
                classification.veryPositive = (simpleMatrix[4] * 100.0).roundToInt()
                val sentimentType = sentence.get(SentimentCoreAnnotations.SentimentClass::class.java)
                sentimentResult.sentimentType = sentimentType
                sentimentResult.sentimentClass = classification
                sentimentResult.sentimentScore = RNNCoreAnnotations.getPredictedClass(tree)
            }
        }
        return sentimentResult
    }
}
