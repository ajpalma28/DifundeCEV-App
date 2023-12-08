package com.ajptech.difundecevapp;

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.FileProvider
import com.ajptech.difundecevapp.data.HermandadIG
import com.ajptech.difundecevapp.data.HermandadTW
import com.ajptech.difundecevapp.data.Noticia
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class App {

    fun compruebaOtros(marca: CheckBox, texto: EditText): Boolean {
        var res = false
        if(marca.isChecked && texto.text.isEmpty()){
            res = true
        }else if(!marca.isChecked && texto.text.isNotEmpty()){
            res = true
        }
        return res
    }

    fun compruebaLongitudOtros(marca: CheckBox, texto: EditText): Boolean {
        var res = false
        if(marca.isChecked){
            if(texto.text.toString().replace(" ","").length<3){
                res = true
            }
        }
        return res
    }

    fun reiniciaProceso(checks: List<CheckBox>, texto: EditText, inputEnlace: EditText, enlace: String) {
        for(check in checks){
            check.isChecked=false
        }
        if(!texto.text.equals(""))
            texto.setText("")
        if(!inputEnlace.text.equals(enlace))
            inputEnlace.setText(enlace)
    }

    fun generaTextoX(checks: List<CheckBox>, noticia: Noticia, otros: EditText): String{
        val base = "\uD83D\uDD34 " + noticia.titular+"\n\n⬇ "
        val final = "\n"+noticia.enlace
        var res = ""
        for(check in checks){
            if(check.isChecked){
                if(check.id == R.id.cbHdadRocio){
                    res+=HermandadTW.ROCIO
                }
                if(check.id == R.id.cbHdadCarmen){
                    res+=HermandadTW.CARMEN
                }
                if(check.id == R.id.cbHdadAlcora){
                    res+=HermandadTW.PATRONA
                }
                if(check.id == R.id.cbHdadBorriquita){
                    res+=HermandadTW.BORRIQUITA
                }
                if(check.id == R.id.cbHdadEsperanza){
                    res+=HermandadTW.ESPERANZA
                }
                if(check.id == R.id.cbHdadCautivo){
                    res+=HermandadTW.CAUTIVO
                }
                if(check.id == R.id.cbHdadRosario){
                    res+=HermandadTW.VERACRUZ
                }
                if(check.id == R.id.cbHdadPiedad){
                    res+=HermandadTW.PIEDAD
                }
                if(check.id == R.id.cbHdadJesus){
                    res+=HermandadTW.NAZARENO
                }
                if(check.id == R.id.cbHdadDolores){
                    res+=HermandadTW.DOLORES
                }
                if(check.id == R.id.cbParroquia){
                    res+=HermandadTW.PARROQUIA
                }
                if(check.id == R.id.cbAyuntamiento){
                    res+=HermandadTW.AYUNTAMIENTO
                }
                if(check.id == R.id.cbRMartin){
                    res+=HermandadTW.RAMONMARTIN
                }
                if(check.id == R.id.cbBMSMdelAlcor){
                    res+=HermandadTW.BANDAVISO
                }
                if(check.id == R.id.cbBCTMerced){
                    res+=HermandadTW.MERCED
                }
                if(check.id == R.id.cbSFJ && !res.contains(HermandadTW.VERACRUZ.toString())){
                    res+=HermandadTW.SFJ
                }
                if(check.id == R.id.cbMisericordia && !res.contains(HermandadTW.NAZARENO.toString())){
                    res+=HermandadTW.MISERICORDIA
                }
                if(check.id == R.id.cbCorazonDeJesus && !res.contains(HermandadTW.PARROQUIA.toString())){
                    res+=HermandadTW.CORAZON
                }
                if(check.id == R.id.cbArchiSevilla){
                    res+=HermandadTW.ARZOBISPADO
                }
                if(check.id == R.id.cbConsejo && !res.contains(HermandadTW.AYUNTAMIENTO.toString())){
                    res+=HermandadTW.CONSEJO
                }
                if(check.id == R.id.cbReyes && !res.contains(HermandadTW.NAZARENO.toString())){
                    res+=HermandadTW.REYES
                }
                if(check.id == R.id.cbOtros){
                    res+=addOtros(otros.text.toString())
                }
            }


        }
        return base+res+final
    }

    fun generaTextoInstagram(checks: List<CheckBox>, noticia: Noticia, otros: EditText): String{
        val base = "\uD83D\uDD34 " + noticia.titular+"\n\n⬇ "
        val final = "\n"+noticia.enlace+"\n#cofradiaselviso #elvisodelalcor"
        var res = ""
        for(check in checks){
            if(check.isChecked){
                if(check.id == R.id.cbHdadRocio){
                    res+=HermandadIG.ROCIO
                }
                if(check.id == R.id.cbHdadCarmen){
                    res+=HermandadIG.CARMEN
                }
                if(check.id == R.id.cbHdadAlcora){
                    res+=HermandadIG.PATRONA
                }
                if(check.id == R.id.cbHdadBorriquita){
                    res+=HermandadIG.BORRIQUITA
                }
                if(check.id == R.id.cbHdadEsperanza){
                    res+=HermandadIG.ESPERANZA
                }
                if(check.id == R.id.cbHdadCautivo){
                    res+=HermandadIG.CAUTIVO
                }
                if(check.id == R.id.cbHdadRosario){
                    res+=HermandadIG.VERACRUZ
                }
                if(check.id == R.id.cbHdadPiedad){
                    res+=HermandadIG.PIEDAD
                }
                if(check.id == R.id.cbHdadJesus){
                    res+=HermandadIG.NAZARENO
                }
                if(check.id == R.id.cbHdadDolores){
                    res+=HermandadIG.DOLORES
                }
                if(check.id == R.id.cbParroquia){
                    res+=HermandadIG.PARROQUIA
                }
                if(check.id == R.id.cbAyuntamiento){
                    res+=HermandadIG.AYUNTAMIENTO
                }
                if(check.id == R.id.cbRMartin){
                    res+=HermandadIG.RAMONMARTIN
                }
                if(check.id == R.id.cbBMSMdelAlcor){
                    res+=HermandadIG.BANDAVISO
                }
                if(check.id == R.id.cbBCTMerced){
                    res+=HermandadIG.MERCED
                }
                if(check.id == R.id.cbSFJ && !res.contains(HermandadIG.VERACRUZ.toString())){
                    res+=HermandadIG.SFJ
                }
                if(check.id == R.id.cbMisericordia && !res.contains(HermandadIG.NAZARENO.toString())){
                    res+=HermandadIG.MISERICORDIA
                }
                if(check.id == R.id.cbCorazonDeJesus && !res.contains(HermandadIG.PARROQUIA.toString())){
                    res+=HermandadIG.CORAZON
                }
                if(check.id == R.id.cbArchiSevilla){
                    res+=HermandadIG.ARZOBISPADO
                }
                if(check.id == R.id.cbConsejo){
                    res+=HermandadIG.CONSEJO
                }
                if(check.id == R.id.cbReyes && !res.contains(HermandadIG.NAZARENO.toString())){
                    res+=HermandadIG.REYES
                }
                if(check.id == R.id.cbLeonRedondo){
                    res+=HermandadIG.JOSEANTONIO
                }
                if(check.id == R.id.cbOtros){
                    res+=addOtros(otros.text.toString())
                }
            }


        }
        return base+res+final
    }

    private fun addOtros(texto: String): String{
        var res = ""
        val aux = mutableListOf<String>()
        if(texto.contains(" ")){
            val aux2 = texto.split(" ")
            for(e in aux2){
                aux.add(e)
            }
        }else{
            aux.add(texto)
        }
        for(e in aux){
            e.trim()
            val aux3: String = if(!e.startsWith("@")){
                "@$e"
            }else{
                e
            }
            res+= "$aux3 "
        }
        return res
    }

    fun generaTextoTelegram(noticia: Noticia): String{
        return "\uD83D\uDD34 "+noticia.titular.uppercase()+"\n\n"+noticia.enlace
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun abrirTwitterConContenido(contenido: String, context: Context) {
        val tweetIntent = Intent(Intent.ACTION_SEND)
        tweetIntent.putExtra(Intent.EXTRA_TEXT, contenido)
        tweetIntent.type = "text/plain"

        // Verificar si hay aplicaciones que pueden manejar este intent
        val infoList: List<ResolveInfo> =
            context.packageManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY)

        if (infoList.isNotEmpty()) {
            // Crear un chooser para permitir al usuario seleccionar la aplicación
            val chooser = Intent.createChooser(tweetIntent, "Compartir como Post en X")
            chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(chooser)
        } else {
            Handler(Looper.getMainLooper()).post {
                val txtMostrar = Toast.makeText(context, "No se encuentra ninguna aplicación para compartir este contenido.", Toast.LENGTH_LONG)
                txtMostrar.show()
            }
        }
    }

    private suspend fun crearArchivoTemporal(context: Context, urlImagen: String): File {
        return withContext(Dispatchers.IO){
            try {
                val url = URL(urlImagen)
                val connection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input: InputStream = connection.inputStream
                val bitmap = BitmapFactory.decodeStream(input)

                val file = File(context.cacheDir, "imagen_temporal.jpg")
                val fileOutputStream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                fileOutputStream.close()

                return@withContext file
            } catch (e: Exception) {
                e.printStackTrace()
            }

            // En caso de error, puedes retornar un archivo temporal vacío o manejarlo de acuerdo a tus necesidades
            return@withContext File(context.cacheDir, "imagen_temporal.jpg")
        }

    }

    @SuppressLint("QueryPermissionsNeeded")
    suspend fun compartirEnInstagram(texto: String, context: Context, imagen: String) {
        // Crear un archivo temporal con la imagen que quieres compartir
        val imagenFile = crearArchivoTemporal(context, imagen)

        val uri = FileProvider.getUriForFile(context, "com.ajptech.difundecevapp.fileprovider", imagenFile)

        // Guardar la imagen en el intent
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/*"
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
        copiar(context, texto)

        // Verificar si hay aplicaciones que pueden manejar este intent
        val infoList: List<ResolveInfo> =
            context.packageManager.queryIntentActivities(shareIntent, PackageManager.MATCH_DEFAULT_ONLY)

        if (infoList.isNotEmpty()) {
            // Crear un chooser para permitir al usuario seleccionar la aplicación
            val chooser = Intent.createChooser(shareIntent, "Compartir en el Feed de INSTAGRAM")
            chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(chooser)
        } else {
            Handler(Looper.getMainLooper()).post {
                val txtMostrar = Toast.makeText(context, "No se encuentra ninguna aplicación para compartir este contenido.", Toast.LENGTH_LONG)
                txtMostrar.show()
            }
        }
    }

    private fun copiar(context: Context, text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Texto copiado", text)
        clipboard.setPrimaryClip(clip)
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun compartirEnTelegram(contenido: String, context: Context) {
        val telegramComp = Intent(Intent.ACTION_SEND)
        telegramComp.putExtra(Intent.EXTRA_TEXT, contenido)
        telegramComp.type = "text/plain"

        // Verificar si hay aplicaciones que pueden manejar este intent
        val infoList: List<ResolveInfo> =
            context.packageManager.queryIntentActivities(telegramComp, PackageManager.MATCH_DEFAULT_ONLY)

        if (infoList.isNotEmpty()) {
            // Crear un chooser para permitir al usuario seleccionar la aplicación
            val chooser = Intent.createChooser(telegramComp, "Compartir en el canal de TELEGRAM")
            chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(chooser)
        } else {
            // Manejar el caso en el que no hay aplicaciones disponibles para manejar el intent
            // Puedes mostrar un mensaje al usuario o realizar alguna otra acción
        }
    }



}
