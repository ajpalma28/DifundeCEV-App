package com.ajptech.difundecevapp.data

import kotlin.IllegalArgumentException
import kotlin.String

enum class HermandadTW {

    NOVALUE,
    REYES,
    ROCIO,
    CARMEN,
    PATRONA,
    BORRIQUITA,
    ESPERANZA,
    CAUTIVO,
    VERACRUZ,
    PIEDAD,
    NAZARENO,
    DOLORES,
    PARROQUIA,
    AYUNTAMIENTO,
    MERCED,
    BANDAVISO,
    RAMONMARTIN,
    JOSEANTONIO,
    SFJ,
    MISERICORDIA,
    CORAZON,
    ARZOBISPADO,
    CONSEJO;

    fun hayHdad(hermandad: String): HermandadTW? {
        return try {
            HermandadTW.valueOf(hermandad)
        } catch (ex: IllegalArgumentException) {
            NOVALUE
        }
    }

    override fun toString(): String {
        return when (this) {
            NOVALUE -> ""
            REYES -> "@NazarenoViso "
            ROCIO -> "@HdadRocioViso "
            CARMEN -> "@HdadCarmenViso "
            PATRONA -> "@StaMariaAlcor "
            BORRIQUITA -> "@SagradaEntradaV "
            ESPERANZA -> "@Esperanza_Viso "
            CAUTIVO -> "@HdadCautivoViso "
            VERACRUZ -> "@HdadRosarioViso "
            PIEDAD -> "@HdadPiedadViso "
            NAZARENO -> "@NazarenoViso "
            DOLORES -> "@HdadDoloresViso "
            PARROQUIA -> "@sMariadelAlcor "
            AYUNTAMIENTO -> "@ElVisodelAlcor_ "
            MERCED -> "@BctMercedViso "
            BANDAVISO -> "@bandavisoalcor "
            RAMONMARTIN -> "@EscultorRMartin "
            JOSEANTONIO -> ""
            SFJ -> "@HdadRosarioViso "
            MISERICORDIA -> "@NazarenoViso "
            CORAZON -> "@sMariadelAlcor "
            ARZOBISPADO -> "@Archisevilla1 "
            CONSEJO -> "@ElVisodelAlcor_ "
        }
    }
}