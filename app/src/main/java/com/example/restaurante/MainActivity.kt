package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ckbEntrada: CheckBox
    private lateinit var ckbEntretiempo: CheckBox
    private lateinit var ckbPlatoFuerte: CheckBox
    private lateinit var ckbBebida: CheckBox
    private lateinit var rdgEntrada: RadioGroup
    private lateinit var rdgEntretiempo: RadioGroup
    private lateinit var rdgPlatoFuerte: RadioGroup
    private lateinit var rdgBebida: RadioGroup
    private lateinit var rdbSopaDelDia: RadioButton
    private lateinit var rdbSopaAzteca: RadioButton
    private lateinit var rdbSopaDeHongos: RadioButton
    private lateinit var rdbArroz: RadioButton
    private lateinit var rdbCoditos: RadioButton
    private lateinit var rdbEnchiladas: RadioButton
    private lateinit var rdbCarneAzada: RadioButton
    private lateinit var rdbChileRelleno: RadioButton
    private lateinit var rdbAgua: RadioButton
    private lateinit var rdbRefresco: RadioButton
    private lateinit var btnOrdenar: Button
    private lateinit var btnVerOrdenes: Button

    private var entrada: String = ""
    private var entretiempo: String = ""
    private var platoFuerte: String = ""
    private var bebida: String = ""

    private var listaOrdenes: MutableList<Orden> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ckbEntrada = findViewById(R.id.ckbEntrada)
        ckbEntretiempo = findViewById(R.id.ckbEntretiempo)
        ckbPlatoFuerte = findViewById(R.id.ckbPlatoFuerte)
        ckbBebida = findViewById(R.id.ckbBebida)
        rdgEntrada = findViewById(R.id.rdgEntrada)
        rdgEntretiempo = findViewById(R.id.rdgEntretiempo)
        rdgPlatoFuerte = findViewById(R.id.rdgPlatoFuerte)
        rdgBebida = findViewById(R.id.rdgBebida)
        rdbSopaDelDia = findViewById(R.id.rdbSopaDelDia)
        rdbSopaAzteca = findViewById(R.id.rdbSopaAzteca)
        rdbSopaDeHongos = findViewById(R.id.rdbSopaDeHongos)
        rdbArroz = findViewById(R.id.rdbArroz)
        rdbCoditos = findViewById(R.id.rdbCoditos)
        rdbEnchiladas = findViewById(R.id.rdbEnchilada)
        rdbCarneAzada = findViewById(R.id.rdbCarneAzada)
        rdbChileRelleno = findViewById(R.id.rdbChileRelleno)
        rdbAgua = findViewById(R.id.rdbAgua)
        rdbRefresco = findViewById(R.id.rdbRefresco)
        btnOrdenar = findViewById(R.id.btnOrdenar)
        btnVerOrdenes = findViewById(R.id.btnVerOrdenes)

        ckbEntrada.setOnClickListener(this)
        ckbEntretiempo.setOnClickListener(this)
        ckbPlatoFuerte.setOnClickListener(this)
        ckbBebida.setOnClickListener(this)

        btnOrdenar.setOnClickListener {
            if(entrada.isBlank()&&entretiempo.isBlank()&&platoFuerte.isBlank()&&bebida.isBlank()) {
                Toast.makeText(this, "Aun no has escojido nada", Toast.LENGTH_LONG).show()
            } else {
                listaOrdenes.add(Orden(entrada, entretiempo, platoFuerte, bebida))
            }
        }

        btnVerOrdenes.setOnClickListener {
            var msg: String = ""
            var index: Int = 0
            for (orden in listaOrdenes) {
                index++
                msg += "Orden #${index}\n"
                msg += orden.toString()
            }
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.ckbEntrada -> {
                if (ckbEntrada.isChecked) {
                    rdgEntrada.visibility = View.VISIBLE
                    rdgEntrada.setOnCheckedChangeListener { radioGroup, i ->
                        when(i) {
                            R.id.rdbSopaDelDia -> {
                                entrada = rdbSopaDelDia.text.toString()
                            }
                            R.id.rdbSopaAzteca -> {
                                entrada = rdbSopaAzteca.text.toString()
                            }
                            R.id.rdbSopaDeHongos -> {
                                entrada = rdbSopaDeHongos.text.toString()
                            }
                        }
                    }
                } else {
                    rdgEntrada.visibility = View.GONE
                    rdgEntrada.clearCheck()
                    entrada = ""
                }
            }

            R.id.ckbEntretiempo -> {
                if (ckbEntretiempo.isChecked) {
                    rdgEntretiempo.visibility = View.VISIBLE
                    rdgEntretiempo.setOnCheckedChangeListener { radioGroup, i ->
                        when(i) {
                            R.id.rdbArroz -> {
                                entretiempo = rdbArroz.text.toString()
                            }
                            R.id.rdbCoditos -> {
                                entretiempo = rdbCoditos.text.toString()
                            }
                        }
                    }
                } else {
                    rdgEntretiempo.visibility = View.GONE
                    rdgEntretiempo.clearCheck()
                    entretiempo = ""
                }
            }

            R.id.ckbPlatoFuerte -> {
                if (ckbPlatoFuerte.isChecked) {
                    rdgPlatoFuerte.visibility = View.VISIBLE
                    rdgPlatoFuerte.setOnCheckedChangeListener { radioGroup, i ->
                        when(i) {
                            R.id.rdbEnchilada -> {
                                platoFuerte = rdbEnchiladas.text.toString()
                            }
                            R.id.rdbCarneAzada -> {
                                platoFuerte = rdbCarneAzada.text.toString()
                            }
                            R.id.rdbChileRelleno -> {
                                platoFuerte = rdbChileRelleno.text.toString()
                            }
                        }
                    }
                } else {
                    rdgPlatoFuerte.visibility = View.GONE
                    rdgPlatoFuerte.clearCheck()
                    platoFuerte = ""
                }
            }

            R.id.ckbBebida -> {
                if (ckbBebida.isChecked) {
                    rdgBebida.visibility = View.VISIBLE
                    rdgBebida.setOnCheckedChangeListener { radioGroup, i ->
                        when(i) {
                            R.id.rdbAgua -> {
                                bebida = rdbAgua.text.toString()
                            }
                            R.id.rdbRefresco -> {
                                bebida = rdbRefresco.text.toString()
                            }
                        }
                    }
                } else {
                    rdgBebida.visibility = View.GONE
                    rdgBebida.clearCheck()
                    bebida = ""
                }
            }
        }
    }
}