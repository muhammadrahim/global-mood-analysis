package to.the.moon


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import to.the.moon.twitter.Parser

class ParserTest {

    @Test
    fun `should parse twitter json into tweet`() {
        val json = """{
        "created_at": "Thu Mar 04 13:23:37 +0000 2021",
        "id": 13674657572279787,
        "id_str": "13674657572279787",
        "text": "n26",
        "truncated": false,
        "entities": {
            "hashtags": [],
            "symbols": [],
            "user_mentions": [],
            "urls": []
        },
        "source": "",
        "in_reply_to_status_id": null,
        "in_reply_to_status_id_str": null,
        "in_reply_to_user_id": null,
        "in_reply_to_user_id_str": null,
        "in_reply_to_screen_name": null,
        "user": {
            "id": 583249098,
            "id_str": "583249098",
            "name": "MR",
            "screen_name": "username",
            "location": "",
            "description": "🇸🇬 🇬🇧 🇪🇸",
            "url": null,
            "entities": {
            "description": {
            "urls": []
        }
        },
            "protected": false,
            "followers_count": 382,
            "friends_count": 208,
            "listed_count": 2,
            "created_at": "Thu May 17 21:36:14 +0000 2012",
            "favourites_count": 2901,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 331,
            "lang": null,
            "contributors_enabled": false,
            "is_translator": false,
            "is_translation_enabled": false,
            "profile_background_color": "000000",
            "profile_background_image_url": "http:\/\/abs.twimg.com\/images\/themes\/theme9\/bg.gif",
            "profile_background_image_url_https": "https:\/\/abs.twimg.com\/images\/themes\/theme9\/bg.gif",
            "profile_background_tile": false,
            "profile_image_url": "http:\/\/pbs.twimg.com\/profile_images\/1306597700188532743\/EYbbBmAp_normal.jpg",
            "profile_image_url_https": "https:\/\/pbs.twimg.com\/profile_images\/1306597700188532743\/EYbbBmAp_normal.jpg",
            "profile_banner_url": "https:\/\/pbs.twimg.com\/profile_banners\/583249098\/1601924252",
            "profile_link_color": "1D5870",
            "profile_sidebar_border_color": "000000",
            "profile_sidebar_fill_color": "252429",
            "profile_text_color": "666666",
            "profile_use_background_image": true,
            "has_extended_profile": false,
            "default_profile": false,
            "default_profile_image": false,
            "following": false,
            "follow_request_sent": false,
            "notifications": false,
            "translator_type": "none"
        },
        "geo": null,
        "coordinates": null,
        "place": null,
        "contributors": null,
        "is_quote_status": false,
        "retweet_count": 0,
        "favorite_count": 0,
        "favorited": false,
        "retweeted": false,
        "lang": "und"
    }"""
        val parser = Parser()
        val actual = parser.tweet(json)
        assertEquals(actual.text, "n26")
        assertEquals(actual.id, "13674657572279787")
    }
}