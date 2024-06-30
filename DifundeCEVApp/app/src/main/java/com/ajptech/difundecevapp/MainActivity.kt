package com.ajptech.difundecevapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.ajptech.difundecevapp.data.Noticia
import com.ajptech.difundecevapp.data.obtenerTitularesDeNoticias
import com.ajptech.difundecevapp.databinding.ActivityPrincipalBinding
import com.ajptech.difundecevapp.exceptions.InvalidInputOtrosException
import com.ajptech.difundecevapp.exceptions.InvalidLenghtOtrosException
import com.ajptech.difundecevapp.exceptions.errorInputOtros
import com.ajptech.difundecevapp.exceptions.errorLengthOtros
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    private var objetos: ActivityPrincipalBinding? = null

    private val noticiasDef = mutableListOf<Noticia>()

    private val checks = mutableListOf<CheckBox>()

    private val auxiliares = App()

    private fun main() = runBlocking {
        val noticias = obtenerTitularesDeNoticias()

        if (noticias.isNotEmpty()) {
            println("Titulares y enlaces de noticias:")
            noticias.forEach { (titular, enlace, imagen) ->
                println("Título: $titular")
                println("Enlace: $enlace")
                println()
                noticiasDef.add(Noticia(titular, enlace, imagen))
            }
        } else {
            println("No se pudo obtener información de noticias.")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()
        setContentView(R.layout.activity_principal)
        objetos = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(objetos!!.root)

        val primeraLinea = objetos!!.textUrl
        val textocabecera = "Última entrada publicada en cofradiaselviso.com:<br /><br /><b>"+noticiasDef[0].titular.uppercase()+"</b>"
        primeraLinea.text = Html.fromHtml(textocabecera,0)

        val entradaUrl = objetos!!.editTextText
        entradaUrl.setText(noticiasDef[0].enlace)

        val rocio = objetos!!.cbHdadRocio
        val carmen = objetos!!.cbHdadCarmen
        val alcora = objetos!!.cbHdadAlcora
        val borriquita = objetos!!.cbHdadBorriquita
        val esperanza = objetos!!.cbHdadEsperanza
        val cautivo = objetos!!.cbHdadCautivo
        val veracruz = objetos!!.cbHdadRosario
        val piedad = objetos!!.cbHdadPiedad
        val nazareno = objetos!!.cbHdadJesus
        val dolores = objetos!!.cbHdadDolores
        val parroquia = objetos!!.cbParroquia
        val ayuntamiento = objetos!!.cbAyuntamiento
        val rmartin = objetos!!.cbRMartin
        val bandaviso = objetos!!.cbBMSMdelAlcor
        val bctmerced = objetos!!.cbBCTMerced
        val sfj = objetos!!.cbSFJ
        val misericordia = objetos!!.cbMisericordia
        val sjc = objetos!!.cbCorazonDeJesus
        val arzobispado = objetos!!.cbArchiSevilla
        val consejo = objetos!!.cbConsejo
        val reyes = objetos!!.cbReyes
        val joseantonio = objetos!!.cbLeonRedondo
        val otros = objetos!!.cbOtros

        checks.add(rocio); checks.add(carmen); checks.add(alcora); checks.add(borriquita)
        checks.add(esperanza); checks.add(cautivo); checks.add(veracruz); checks.add(piedad)
        checks.add(nazareno); checks.add(dolores); checks.add(parroquia); checks.add(ayuntamiento)
        checks.add(rmartin); checks.add(bandaviso); checks.add(bctmerced); checks.add(sfj)
        checks.add(misericordia); checks.add(sjc); checks.add(arzobispado); checks.add(consejo)
        checks.add(reyes); checks.add(joseantonio); checks.add(otros)

        val textoOtros = objetos!!.editOtros

        val btnX = objetos!!.btnX
        val btnIG = objetos!!.btnIG
        val btnTG = objetos!!.btnTG
        val btnCancelar = objetos!!.btnCancela
        val btnAcerca = objetos!!.btnAcercaDe
        val btnSalir = objetos!!.btnSalir

        val pie = objetos!!.imgFinal

        btnX.setOnClickListener {
            try{

                if(auxiliares.compruebaOtros(otros, textoOtros)){
                    throw InvalidInputOtrosException(errorInputOtros)
                }

                if(auxiliares.compruebaLongitudOtros(otros, textoOtros)){
                    throw InvalidLenghtOtrosException(errorLengthOtros)
                }

                val imprime = auxiliares.generaTextoX(checks,noticiasDef[0],textoOtros)
                auxiliares.abrirTwitterConContenido(imprime, applicationContext)
                auxiliares.reiniciaProceso(checks,textoOtros,entradaUrl,noticiasDef[0].enlace)

            } catch (e1: InvalidInputOtrosException) {
                Handler(Looper.getMainLooper()).post {
                    val txtMostrar = Toast.makeText(this, errorInputOtros, Toast.LENGTH_LONG)
                    txtMostrar.show()
                }
                auxiliares.reiniciaProceso(checks,textoOtros,entradaUrl,noticiasDef[0].enlace)
            } catch (e2: InvalidLenghtOtrosException) {
                Handler(Looper.getMainLooper()).post {
                    val txtMostrar = Toast.makeText(this, errorLengthOtros, Toast.LENGTH_LONG)
                    txtMostrar.show()
                }
            } catch (e3: Exception) {
                Handler(Looper.getMainLooper()).post {
                    val txtMostrar = Toast.makeText(this, "Un error extraño ha sucedido. Por favor, inténtelo de nuevo más tarde.", Toast.LENGTH_LONG)
                    txtMostrar.show()
                }
            }

        }

        btnIG.setOnClickListener {
            try{
                if(auxiliares.compruebaOtros(otros, textoOtros)) {
                    throw InvalidInputOtrosException(errorInputOtros)
                }

                if(auxiliares.compruebaLongitudOtros(otros, textoOtros)){
                    throw InvalidLenghtOtrosException(errorLengthOtros)
                }

                val imprime = auxiliares.generaTextoInstagram(checks,noticiasDef[0],textoOtros)
                lifecycleScope.launch {
                    auxiliares.compartirEnInstagram(imprime, applicationContext, noticiasDef[0].imagen)
                }

            } catch (e1: InvalidInputOtrosException) {
                Handler(Looper.getMainLooper()).post {
                    val txtMostrar = Toast.makeText(this, errorInputOtros, Toast.LENGTH_LONG)
                    txtMostrar.show()
                }
                auxiliares.reiniciaProceso(checks,textoOtros,entradaUrl,noticiasDef[0].enlace)
            } catch (e2: InvalidLenghtOtrosException) {
                Handler(Looper.getMainLooper()).post {
                    val txtMostrar = Toast.makeText(this, errorLengthOtros, Toast.LENGTH_LONG)
                    txtMostrar.show()
                }
            } catch (e3: Exception) {
                Handler(Looper.getMainLooper()).post {
                    val txtMostrar = Toast.makeText(this, "Un error extraño ha sucedido. Por favor, inténtelo de nuevo más tarde.", Toast.LENGTH_LONG)
                    txtMostrar.show()
                }
            }

        }

        btnTG.setOnClickListener{
            val texto = auxiliares.generaTextoTelegram(noticiasDef[0])
            auxiliares.compartirEnTelegram(texto, applicationContext)
            auxiliares.reiniciaProceso(checks,textoOtros,entradaUrl,noticiasDef[0].enlace)
        }


        btnCancelar.setOnClickListener {
            auxiliares.reiniciaProceso(checks,textoOtros,entradaUrl,noticiasDef[0].enlace)
        }

        btnAcerca.setOnClickListener {
            val intent = Intent(this, AcercaDeActivity::class.java)
            startActivity(intent)
        }

        btnSalir.setOnClickListener{
            finish()
        }

        pie.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://cofradiaselviso.com/")))
        }

    }


}