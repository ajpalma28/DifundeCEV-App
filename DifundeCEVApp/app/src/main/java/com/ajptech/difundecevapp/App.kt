package com.ajptech.difundecevapp;

import java.net.URL
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import tw.ktrssreader.kotlin.model.channel.RssStandardChannel
import tw.ktrssreader.kotlin.parser.RssStandardParser

class App {


    private val ktorClient = HttpClient(CIO)
    suspend fun getArticles(
        urlString: String = "https://cofradiaselviso.com/rss"
    ): RssStandardChannel {
        val response = ktorClient.get(urlString).bodyAsText()
        return RssStandardParser().parse(response)
    }

}
