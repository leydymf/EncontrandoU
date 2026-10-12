package com.leydymacareo.encontrandou.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidacionesTest {

    @Test
    fun nombre_vacio_o_corto_es_invalido() {
        assertEquals(false to "El nombre es requerido", validarNombre("  "))
        assertEquals(false to "El nombre es demasiado corto", validarNombre("Al"))
    }

    @Test
    fun nombre_de_tres_o_mas_letras_es_valido() {
        assertTrue(validarNombre("Ana").first)
    }

    @Test
    fun correo_debe_ser_institucional() {
        assertEquals(false to "El correo es requerido", validarCorreo(""))
        assertEquals(false to "Debe usar correo @unab.edu.co", validarCorreo("ana@gmail.com"))
        assertTrue(validarCorreo("ana.perez@unab.edu.co").first)
    }

    @Test
    fun correo_institucional_con_formato_invalido_se_rechaza() {
        assertEquals(false to "Formato de correo inválido", validarCorreo("ana perez@unab.edu.co"))
        assertEquals(false to "Formato de correo inválido", validarCorreo("@unab.edu.co"))
    }

    @Test
    fun contrasena_exige_longitud_mayuscula_y_numero() {
        assertEquals(false to "La contraseña es requerida", validarContrasena(""))
        assertEquals(false to "Debe tener al menos 6 caracteres", validarContrasena("Ab1"))
        assertEquals(false to "Debe tener al menos una mayúscula", validarContrasena("abcdef1"))
        assertEquals(false to "Debe tener al menos un número", validarContrasena("Abcdefg"))
        assertTrue(validarContrasena("Abcdef1").first)
    }

    @Test
    fun confirmacion_debe_coincidir() {
        assertEquals(false to "Confirme su contraseña", validarConfirmacion("Abcdef1", ""))
        assertEquals(false to "Las contraseñas no coinciden", validarConfirmacion("Abcdef1", "Abcdef2"))
        assertTrue(validarConfirmacion("Abcdef1", "Abcdef1").first)
    }

    @Test
    fun codigo_de_encargado() {
        assertFalse(validarCodigoEncargado("").first)
        assertEquals(false to "Código incorrecto", validarCodigoEncargado("OTRO"))
        assertTrue(validarCodigoEncargado("MOVILES2025-1").first)
    }
}
