package com.ajptech.difundecevapp.exceptions

val errorLengthOtros = "Si añade OTROS, la mención debe ser correcta."

internal class InvalidLenghtOtrosException(mensaje: String?) : Exception(mensaje)