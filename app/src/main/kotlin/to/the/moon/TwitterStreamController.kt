package to.the.moon

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TwitterStreamController(private val twitterStreamProducer: TwitterStreamProducer) {

    @RequestMapping("/stream")
    fun stream(): String {
        twitterStreamProducer.stream()
        return "Hey"
    }
}
