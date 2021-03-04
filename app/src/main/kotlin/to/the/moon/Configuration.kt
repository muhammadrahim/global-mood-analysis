package to.the.moon

import edu.stanford.nlp.pipeline.StanfordCoreNLP
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
open class Configuration {

    @Bean
    open fun pipeline(): StanfordCoreNLP {
        val properties = Properties()
        properties.setProperty("annotators", "tokenize, ssplit, parse, sentiment")
        return StanfordCoreNLP(properties)
    }
}