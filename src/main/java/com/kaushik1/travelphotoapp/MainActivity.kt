package com.kaushik1.travelphotoapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var currentImage = 0;
    lateinit var image : ImageView
    var places = arrayOf("Red Fort", "India Gate", "Lotus Temple", "Akshar Dham", "Qutub Minar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val next = findViewById<ImageButton>(R.id.btnNext)
        val placeName = findViewById<TextView>(R.id.textView2)
        next.setOnClickListener{
            // i want to get the next image

            var idCurrentImageString = "pic$currentImage"

            // I have to get the integer address associated with view

            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage+1)%5
            var idImagetoShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImagetoShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]
        }

        prev.setOnClickListener {
            // I want to see the previous image
            var idCurrentImageString = "pic$currentImage"

            // I have to get the integer address associated with view

            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage-1)%5
            var idImagetoShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImagetoShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            placeName.text = places[currentImage]
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}