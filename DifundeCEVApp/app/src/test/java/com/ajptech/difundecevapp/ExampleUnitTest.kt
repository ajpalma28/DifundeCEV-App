package com.ajptech.difundecevapp

import org.junit.Test

import org.junit.Assert.*
import com.ajptech.difundecevapp.App
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.jetbrains.annotations.Async.Execute

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        //println(App(ktorClient).getArticles())
    }

    /* TODO */
    @Execute
    suspend fun ojo(){
        println(App().getArticles().items?.get(0)?.author.toString())
    }
}