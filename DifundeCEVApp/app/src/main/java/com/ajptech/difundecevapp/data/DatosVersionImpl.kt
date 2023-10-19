package com.ajptech.difundecevapp.data

import android.media.Image
import java.nio.file.Path
import java.nio.file.Paths

class DatosVersionImpl : DatosVersion {

    private val NOMBRE = "DifundeCEV"
    private val VERSION = "Versión v1.3.0.0"
    private val FECHA = "Última actualización: 24/05/2023"

    private var v: String? = null;
    private var f: String? = null;
    private var dir1: String? = null;
    private var n: String? = null
    private var icono: Image? = null

    fun DatosVersionImpl() {
        n = NOMBRE
        v = VERSION
        f = FECHA
        val currentRelativePath: Path = Paths.get("")
        val ejem: String = currentRelativePath.toAbsolutePath().toString()
        ejem.replace("\\", "/")
        dir1 = "$ejem/Data/"
        //icono = Icon(javaClass.getResource("favCEV2.png")).getImage()
    }

    override fun getNombre(): String? {
        return n
    }

    override fun getVersion(): String? {
        return v
    }

    override fun getFecha(): String? {
        return f
    }

    override fun getDirectorio(): String? {
        return dir1
    }

    override fun getIcono(): Image? {
        TODO("Not yet implemented")
    }

    override fun getCabecera(): String? {
        return "$n - $v - $f"
    }
}