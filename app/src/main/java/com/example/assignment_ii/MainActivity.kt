package com.example.assignment_ii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val chemicalList = mutableListOf("Gold", "Platinum")
    private lateinit var chemicalTextView: TextView
    private lateinit var addChemicalEditText: EditText
    private lateinit var guessChemicalEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chemicalTextView = findViewById(R.id.chemicalTextView)
        addChemicalEditText = findViewById(R.id.addChemicalEditText)
        guessChemicalEditText = findViewById(R.id.guessChemicalEditText)

        val addButton: Button = findViewById(R.id.addButton)
        val guessButton: Button = findViewById(R.id.guessButton)

        updateChemicalList()

        addButton.setOnClickListener {
            addChemical()
        }

        guessButton.setOnClickListener {
            guessChemical()
        }
    }

    private fun addChemical() {
        val newChemical = addChemicalEditText.text.toString().trim()
        if (newChemical.isNotEmpty()) {
            if (!chemicalList.contains(newChemical)) {
                chemicalList.add(newChemical)
                updateChemicalList()
                addChemicalEditText.text.clear()
            } else {
                chemicalTextView.text = "Chemical already exists"
            }
        }
    }

    private fun guessChemical() {
        val guessedChemical = guessChemicalEditText.text.toString().trim()
        if (guessedChemical.isNotEmpty()) {
            if (chemicalList.contains(guessedChemical)) {
                chemicalTextView.text = getString(R.string.correct_guess, guessedChemical)
            } else {
                chemicalTextView.text = getString(R.string.incorrect_guess, guessedChemical)
            }
            guessChemicalEditText.text.clear()
        }
    }
    private fun updateChemicalList() {
        chemicalTextView.text = "Chemical List:\n"
        for (chemical in chemicalList) {
            chemicalTextView.append("$chemical\n")
        }
    }
}