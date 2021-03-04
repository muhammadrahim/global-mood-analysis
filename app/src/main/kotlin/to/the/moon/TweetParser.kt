package to.the.moon

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class TweetParser {

    fun parse(it: String): Tweet {
        val mapper = jacksonObjectMapper()
        return mapper.readValue(it)
    }
}