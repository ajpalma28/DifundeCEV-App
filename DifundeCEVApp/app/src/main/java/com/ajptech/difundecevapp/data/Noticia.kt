package com.ajptech.difundecevapp.data

import android.provider.ContactsContract.CommonDataKinds.Website.URL
import org.jsoup.Jsoup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

data class Noticia(val titular: String, val enlace: String, val imagen: String)

suspend fun obtenerTitularesDeNoticias(): List<Noticia> {
    return withContext(Dispatchers.IO) {
        try {
            val url = "http://cofradiaselviso.com/rss"
            val document = Jsoup.connect(url).get()

            val noticias = mutableListOf<Noticia>()

            val titulares = document.select("title")
            val enlaces = document.select("link")
            val urlMediaContent = document.select("item media|content[url]").attr("url")

            // Iteramos sobre los titulares para obtener el texto, el enlace y la url de la foto
            var cont = 0
            for (element in titulares) {
                val titular = element.text()
                val enlace = enlaces.get(cont).toString().replace("<link>","").replace("</link>","")
                val imagen = urlMediaContent
                cont += 1
                if(!titular.equals("Cofradías El Viso")){
                    noticias.add(Noticia(titular, enlace, imagen))
                    break
                }
            }

            return@withContext noticias
        } catch (e: IOException) {
            e.printStackTrace()
            return@withContext emptyList()
        }
    }
}