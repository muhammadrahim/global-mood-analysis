package to.the.moon.twitter

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "twitter")
open class TwitterConfiguration {
    lateinit var keywords: List<String>
    lateinit var ckey: String
    lateinit var csecret: String
    lateinit var token: String
    lateinit var secret: String
}
