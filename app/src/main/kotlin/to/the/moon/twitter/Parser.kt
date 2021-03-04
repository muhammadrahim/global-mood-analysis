package to.the.moon.twitter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class Parser {

    fun tweet(it: String): Tweet {
        val mapper = jacksonObjectMapper()
        return mapper.readValue(it)
    }
}