package com.example.pry_app_imc.Modelo

class clsPacienteModelo {

    fun calcularIMC(peso: Double, altura: Double): Double {
        return peso / (altura * altura)
    }

    fun obtenerEstado(imc: Double): String {

        val estado = if (imc < 18.5) {
            "Bajo peso"
        } else if (imc < 25) {
            "Normal"
        } else if (imc < 30) {
            "Sobrepeso"
        } else {
            "Obesidad"
        }

        return estado
    }
}