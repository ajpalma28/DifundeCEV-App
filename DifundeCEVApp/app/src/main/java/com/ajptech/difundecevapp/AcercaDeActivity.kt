package com.ajptech.difundecevapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import com.ajptech.difundecevapp.databinding.ActivityAcercadeBinding
import com.ajptech.difundecevapp.databinding.ActivityPrincipalBinding

class AcercaDeActivity: ComponentActivity() {

    var objetos: ActivityAcercadeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_acercade)
        objetos = ActivityAcercadeBinding.inflate(layoutInflater)
        setContentView(objetos!!.root)

        val atras = objetos!!.adAtras

        atras.setOnClickListener{
            super.onBackPressedDispatcher.onBackPressed()
        }

    }

}