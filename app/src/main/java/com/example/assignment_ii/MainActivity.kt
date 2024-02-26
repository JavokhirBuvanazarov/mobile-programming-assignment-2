package com.example.assignment_ii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val foodList = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    private var foodTextView: TextView? = null
    private var addFood: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodTextView = findViewById(R.id.txtFood)
        addFood = findViewById(R.id.editFood)
    }

    fun addFood(view: View) {
        if (!addFood?.text?.equals("")!!) {
            foodList.add(addFood?.text.toString())
            addFood?.setText("")
        }
    }

    fun decide(view: View) {
        foodTextView?.text = foodList.random()
    }
}