package com.example.tallerappsmoviles

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val value = findViewById<TextInputEditText>(R.id.value)

        val centigradeButton = findViewById<AppCompatButton>(R.id.centigradeButton)
        val fahrenheitButton = findViewById<AppCompatButton>(R.id.fahrenheitButton)
        val kelvinButton = findViewById<AppCompatButton>(R.id.kelvinButton)

        val valueCelsius = findViewById<TextView>(R.id.valueCelsius)
        val valueFahrenheit = findViewById<TextView>(R.id.valueFahrenheit)
        val valueKelvin = findViewById<TextView>(R.id.valueKelvin)

        fun showErrorWhenValueIsEmpty() {
            if (value.text.toString().isEmpty()) {
                valueCelsius.text = "Error"
                valueFahrenheit.text = "Error"
                valueKelvin.text = "Error"
            }
        }

        fun convertFromCelsiusToFahrenheit(value: Double): Double {
            return (value * 9 / 5) + 32
        }

        fun convertFromCelsiusToKelvin(value: Double): Double {
            return value + 273.15
        }

        fun convertFromFahrenheitToCelsius(value: Double): Double {
            return (value - 32) * 5 / 9
        }

        fun convertFromFahrenheitToKelvin(value: Double): Double {
            return (value - 32) * 5 / 9 + 273.15
        }

        fun convertFromKelvinToCelsius(value: Double): Double {
            return value - 273.15
        }

        fun convertFromKelvinToFahrenheit(value: Double): Double {
            return (value - 273.15) * 9 / 5 + 32
        }

        centigradeButton.setOnClickListener {
            if (value.text.toString().isEmpty()) {
                showErrorWhenValueIsEmpty()
            } else {
                val value = value.text.toString().toDouble()
                valueCelsius.text = value.toString()
                valueFahrenheit.text = convertFromCelsiusToFahrenheit(value).toString()
                valueKelvin.text = convertFromCelsiusToKelvin(value).toString()
            }
        }

        fahrenheitButton.setOnClickListener {
            if (value.text.toString().isEmpty()) {
                showErrorWhenValueIsEmpty()
            } else {
                val value = value.text.toString().toDouble()
                valueCelsius.text = convertFromFahrenheitToCelsius(value).toString()
                valueFahrenheit.text = value.toString()
                valueKelvin.text = convertFromFahrenheitToKelvin(value).toString()
            }
        }

        kelvinButton.setOnClickListener {
            if (value.text.toString().isEmpty()) {
                showErrorWhenValueIsEmpty()
            } else {
                val value = value.text.toString().toDouble()
                valueCelsius.text = convertFromKelvinToCelsius(value).toString()
                valueFahrenheit.text = convertFromKelvinToFahrenheit(value).toString()
                valueKelvin.text = value.toString()
            }
        }
    }

}