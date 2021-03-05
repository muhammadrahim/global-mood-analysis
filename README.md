# Twitter keyword stream with sentiment analysis

Tool created for livestreaming tweets containing keywords to then apply [sentiment analysis](https://en.wikipedia.org/wiki/Sentiment_analysis).

This allows for a vague understanding of mood & sentiment around a certain topic or entity.

# To run:

1.) Add the following environment variables:
```
echo 'export CONSUMER_KEY=FILL_IN' >> ~/.zshenv
echo 'export CONSUMER_SECRET=FILL_IN' >> ~/.zshenv
echo 'export TWITTER_TOKEN=FILL_IN' >> ~/.zshenv
echo 'export TWITTER_SECRET=FILL_IN' >> ~/.zshenv
```
2) Update `application.yml` by adding in relevant `keywords` to analyse

Then run:
`./gradlew run`
