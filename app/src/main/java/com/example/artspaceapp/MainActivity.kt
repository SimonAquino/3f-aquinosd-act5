package com.example.artspaceapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val imageView = arrayOf(
        R.drawable.the_car_is_angy,
        R.drawable.car_want_a_kiss,
        R.drawable.approved,
        R.drawable.me_and_the_gang,
        R.drawable.need_a_hand,
    )

    private val textView = arrayOf(
        "I think the car is angy",
        "I think the car want a kiss",
        "Approved",
        "Me and the gang",
        "Need a paw?",
    )

    private var currentIndex = 0

    private lateinit var artImageView: ImageView
    private lateinit var descriptionTextView: TextView
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artImageView = findViewById(R.id.imageView)
        descriptionTextView = findViewById(R.id.textView)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.previous_button)

        updateContent()

        nextButton.setOnClickListener { changeContent(1) }
        prevButton.setOnClickListener { changeContent(-1) }
    }

    private fun updateContent() {
        artImageView.setImageResource(imageView[currentIndex])
        descriptionTextView.text = textView[currentIndex]
    }

    private fun changeContent(direction: Int) {
        currentIndex = (currentIndex + direction).coerceIn(0, imageView.size - 1)
        updateContent()
    }
}