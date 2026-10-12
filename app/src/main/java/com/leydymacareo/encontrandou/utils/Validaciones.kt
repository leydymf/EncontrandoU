package com.leydymacareo.encontrandou.utils

// Formato basico de correo; se usa una expresion propia para poder probarla sin Android
private val FORMATO_CORREO = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

fun validarNombre(nombre: String): Pair<Boolean, String> {
    return when {
        nombre.isBlank() -> false to "El nombre es requerido"
        nombre.length < 3 -> false to "El nombre es demasiado corto"
        else -> true to ""
    }
}

fun validarCorreo(email: String): Pair<Boolean, String> {
    return when {
        email.isBlank() -> false to "El correo es requerido"
        !email.endsWith("@unab.edu.co") -> false to "Debe usar correo @unab.edu.co"
        !FORMATO_CORREO.matches(email) -> false to "Formato de correo inválido"
        else -> true to ""
    }
}

fun validarContrasena(password: String): Pair<Boolean, String> {
    return when {
        password.isBlank() -> false to "La contraseña es requerida"
        password.length < 6 -> false to "Debe tener al menos 6 caracteres"
        !password.any { it.isUpperCase() } -> false to "Debe tener al menos una mayúscula"
        !password.any { it.isDigit() } -> false to "Debe tener al menos un número"
        else -> true to ""
    }
}

fun validarConfirmacion(password: String, confirm: String): Pair<Boolean, String> {
    return when {
        confirm.isBlank() -> false to "Confirme su contraseña"
        confirm != password -> false to "Las contraseñas no coinciden"
        else -> true to ""
    }
}

fun validarCodigoEncargado(codigo: String): Pair<Boolean, String> {
    return when {
        codigo.isBlank() -> false to "El código es requerido"
        codigo != "MOVILES2025-1" -> false to "Código incorrecto"
        else -> true to ""
    }
}


