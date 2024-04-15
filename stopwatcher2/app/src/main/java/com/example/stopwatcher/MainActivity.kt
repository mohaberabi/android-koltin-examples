package com.example.stopwatcher

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.stopwatcher.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private lateinit var servicesIntent: Intent
    private var started = false
    private var time = 0.0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)




        setContentView(binding.root)


        binding.startButton.setOnClickListener {
            startOrStop()
        }
        binding.resetButton.setOnClickListener {

            resetTimer()

        }

        servicesIntent = Intent(this, StopWatchService::class.java)

        registerReceiver(
            updateTime, IntentFilter(StopWatchService.updatedTime),
            RECEIVER_NOT_EXPORTED
        )
    }

    private fun startOrStop() {
        if (started) {
            stopTimer()
        } else {
            startTimer()
        }

    }

    private fun stopTimer() {


        stopService(servicesIntent)
        binding.startButton.text = "Start"
        started = false
    }

    private fun startTimer() {
        servicesIntent.putExtra(
            StopWatchService.currentTime,
            time
        )
        startService(servicesIntent)
        binding.startButton.text = "Stop"

        started = true
    }

    private fun resetTimer() {

        stopTimer()
        time = 0.0
        binding.timeText.text = formatTime(0.0)
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {

            time = intent.getDoubleExtra(
                StopWatchService.currentTime,
                0.0
            )

            binding.timeText.text = formatTime(time)
        }

    }

    private fun formatTime(
        time: Double
    ): String {

        val totalSecondsInDay = 86400
        val timeInt = time.roundToInt()

        val hours = timeInt % totalSecondsInDay / 3600

        val minutes = timeInt % totalSecondsInDay % 3600 / 60
        val seconds = totalSecondsInDay % 3600 % 60

        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}