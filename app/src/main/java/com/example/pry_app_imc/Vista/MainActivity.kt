package com.example.pry_app_imc.Vista

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pry_app_imc.Presentador.clsPacientePresentador
import com.example.pry_app_imc.R

class MainActivity : AppCompatActivity() {
    private lateinit var txtPaciente: EditText
    private lateinit var txtPeso: EditText
    private lateinit var txtEstatura: EditText
    private lateinit var btnCalcularIMC: Button
    private lateinit var txtNombre: TextView
    private lateinit var txtIMC: TextView
    private lateinit var txtEstadoSalud: TextView
    private lateinit var presenter: clsPacientePresentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtPaciente = findViewById(R.id.txtPaciente)
        txtPeso = findViewById(R.id.txtPeso)
        txtEstatura = findViewById(R.id.txtEstatura)
        btnCalcularIMC = findViewById(R.id.btnCalcularIMC)
        txtNombre = findViewById(R.id.txtNombre)
        txtIMC = findViewById(R.id.txtIMC)
        txtEstadoSalud = findViewById(R.id.txtEstadoSalud)

        presenter = clsPacientePresentador(this)

        btnCalcularIMC.setOnClickListener(this::ejecutarAccionCalcularIMC)
    }

    private fun ejecutarAccionCalcularIMC(v: View) {
        val paciente = txtPaciente.text.toString()
        val peso = txtPeso.text.toString()
        val estatura = txtEstatura.text.toString()

        presenter.CalcularIMC(paciente, peso, estatura)
        presenter.ObtenerEstadoSalud(peso, estatura)
    }

    fun mostrarIMC(nombre: String, imc: String) {
        txtNombre.text = "Nombre: $nombre"
        txtIMC.text = "IMC: $imc"
    }

    fun mostrarEstadoSalud(estado: String) {
        txtEstadoSalud.text = "Estado de salud: $estado"
    }
}