package com.example.pry_app_imc.Presentador

import com.example.pry_app_imc.Modelo.clsPacienteModelo
import com.example.pry_app_imc.Vista.MainActivity

class clsPacientePresentador(private val vista: MainActivity) {

    private val modelo = clsPacienteModelo()

    fun CalcularIMC(paciente: String, textoPeso: String, textoEstatura: String) {
        val peso = textoPeso.toDoubleOrNull() ?: 0.0
        val estatura = textoEstatura.toDoubleOrNull() ?: 0.0

        if (peso <= 0 || estatura <= 0) {
            vista.mostrarIMC(paciente, "0")
            return
        }
        val imc = modelo.calcularIMC(peso, estatura)

        vista.mostrarIMC(paciente, String.format("%.2f", imc))
    }

    fun ObtenerEstadoSalud(textoPeso: String, textoEstatura: String) {
        val peso = textoPeso.toDoubleOrNull() ?: 0.0
        val estatura = textoEstatura.toDoubleOrNull() ?: 0.0

        if (peso <= 0 || estatura <= 0) {
            vista.mostrarEstadoSalud("Datos no válidos")
            return
        }

        val imc = modelo.calcularIMC(peso, estatura)
        val estado = modelo.obtenerEstado(imc)

        vista.mostrarEstadoSalud(estado)
    }
}