package to.the.moon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import kotlin.concurrent.thread

@SpringBootApplication
open class App
fun main(args: Array<String>) {
    runApplication<App>(*args)
}