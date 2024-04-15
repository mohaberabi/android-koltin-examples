package com.example.servicesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.servicesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val servicesIntent = Intent(this, MyBgServices::class.java)

        servicesIntent.putExtra("name", "Mohab")
        binding.startButton.setOnClickListener {
            startService(servicesIntent)
        }
        binding.stopButton.setOnClickListener {
            stopService(servicesIntent)
        }


    }
}