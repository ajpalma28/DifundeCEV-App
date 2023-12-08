package com.ajptech.difundecevapp.exceptions

val errorInputOtros = "Debe haber consistencia para la creación del contenido. Si marca la casilla OTROS, debe indicar claramente las cuentas a añadir en el cuadro de texto."

internal class InvalidInputOtrosException(mensaje: String?) : Exception(mensaje)