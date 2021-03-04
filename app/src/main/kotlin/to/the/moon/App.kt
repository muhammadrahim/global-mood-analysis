package to.the.moon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import to.the.moon.twitter.TwitterConfiguration

@SpringBootApplication
@PropertySource("application.yml")
@EnableConfigurationProperties
open class App(private val twitterConfiguration: TwitterConfiguration)

fun main(args: Array<String>) {
    runApplication<App>(*args)
}