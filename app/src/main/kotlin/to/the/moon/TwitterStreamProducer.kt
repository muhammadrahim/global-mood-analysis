/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package to.the.moon

import com.google.common.collect.Lists
import com.twitter.hbc.ClientBuilder
import com.twitter.hbc.core.Constants
import com.twitter.hbc.core.HttpHosts
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint
import com.twitter.hbc.core.processor.StringDelimitedProcessor
import com.twitter.hbc.httpclient.auth.Authentication
import com.twitter.hbc.httpclient.auth.OAuth1
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.TimeUnit.SECONDS


@Component
class TwitterStreamProducer {
    @Value("\${consumer.key}") private lateinit var consumerKey: String
    @Value("\${consumer.secret}") private lateinit var consumerSecret: String
    @Value("\${token}") private lateinit var token: String
    @Value("\${secret}") private lateinit var secret: String
    private val logger: Logger = LoggerFactory.getLogger(TwitterStreamProducer::class.java)
    fun stream() {
        val msgQueue = LinkedBlockingDeque<String>(1000)
        val hoseBirdHosts = HttpHosts(Constants.STREAM_HOST)
        val hoseBirdEndpoint = StatusesFilterEndpoint()

        val terms: List<String> = Lists.newArrayList("n26")
        hoseBirdEndpoint.trackTerms(terms)

        val hoseBirdAuth: Authentication = OAuth1(consumerKey, consumerSecret, token, secret)
        val twitterClient = ClientBuilder()
            .name("HoseBird-Client")
            .hosts(hoseBirdHosts)
            .authentication(hoseBirdAuth)
            .endpoint(hoseBirdEndpoint)
            .processor(StringDelimitedProcessor(msgQueue))
            .build()
        twitterClient.connect()
        while (!twitterClient.isDone) {
            logger.info(msgQueue.poll(5, SECONDS))
        }
    }
}