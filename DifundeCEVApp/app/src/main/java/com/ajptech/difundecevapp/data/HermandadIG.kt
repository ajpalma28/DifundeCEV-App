package com.ajptech.difundecevapp.data

import kotlin.IllegalArgumentException
import kotlin.String

enum class HermandadIG {

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

    fun hayHdad(hermandad: String): HermandadIG? {
        return try {
            HermandadIG.valueOf(hermandad)
        } catch (ex: IllegalArgumentException) {
            NOVALUE
        }
    }

    override fun toString(): String {
        return when (this) {
            NOVALUE -> ""
            REYES -> "@nazarenoviso "
            ROCIO -> "@rociodeelviso "
            CARMEN -> "@hdadcarmenviso "
            PATRONA -> "@stamariaalcor "
            BORRIQUITA -> "@sagradaentradaviso "
            ESPERANZA -> "@redencionyesperanza "
            CAUTIVO -> "@hdadcautivoviso "
            VERACRUZ -> "@hdadveracruzyrosarioviso "
            PIEDAD -> "@hdadpiedadviso "
            NAZARENO -> "@nazarenoviso "
            DOLORES -> "@hdaddoloresviso "
            PARROQUIA -> "@parroquiasantamariadelalcor "
            AYUNTAMIENTO -> "@elvisodelalcor_ "
            MERCED -> "@bctmercedviso "
            BANDAVISO -> "@bandavisoalcor "
            RAMONMARTIN -> "@sculpture_ramon_martin "
            JOSEANTONIO -> "artesacro_leonredondo "
            SFJ -> "@hdadveracruzyrosarioviso "
            MISERICORDIA -> "@nazarenoviso "
            CORAZON -> "@parroquiasantamariadelalcor "
            ARZOBISPADO -> "@archisevilla "
            CONSEJO -> "@consejodehermandades.elviso "
        }
    }
}