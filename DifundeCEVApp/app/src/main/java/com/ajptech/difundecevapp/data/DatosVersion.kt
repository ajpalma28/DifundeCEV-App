package com.ajptech.difundecevapp.data

import android.media.Image




interface DatosVersion {

    fun getNombre(): String?
    fun getVersion(): String?
    fun getFecha(): String?
    fun getDirectorio(): String?
    fun getIcono(): Image?
    fun getCabecera(): String?

}