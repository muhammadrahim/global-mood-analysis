package to.the.moon.twitter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import to.the.moon.twitter.Tweet

class TweetParser {

    fun parse(it: String): Tweet {
        val mapper = jacksonObjectMapper()
        return mapper.readValue(it)
    }
}