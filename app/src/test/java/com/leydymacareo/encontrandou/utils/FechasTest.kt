package com.leydymacareo.encontrandou.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.format.DateTimeParseException

class FechasTest {

    @Test
    fun obtiene_el_mes_en_espanol_con_mayuscula_inicial() {
        assertEquals("Marzo", obtenerMesDesdeFecha("15/03/2025"))
        assertEquals("Diciembre", obtenerMesDesdeFecha("01/12/2024"))
    }

    @Test
    fun obtiene_el_anio() {
        assertEquals("2025", obtenerAnioDesdeFecha("15/03/2025"))
    }

    @Test(expected = DateTimeParseException::class)
    fun fecha_con_formato_distinto_lanza_error() {
        obtenerMesDesdeFecha("2025-03-15")
    }
}
