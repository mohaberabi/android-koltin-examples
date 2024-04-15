package com.example.stopwatcher

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.util.Timer
import java.util.TimerTask

class StopWatchService : Service() {
    private val timer = Timer()
    override fun onBind(intent: Intent?): IBinder? = null


    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {
        val time = intent?.getDoubleExtra(currentTime, 0.0)

        timer.scheduleAtFixedRate(StopWatchTimerTask(time!!), 0, 1000)


        // system will not restart it automatically
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }


    companion object {

        const val currentTime = "current time "
        const val updatedTime = "updated time "

    }

    private inner class StopWatchTimerTask(
        private var time: Double
    ) : TimerTask() {

        override fun run() {
            val intent = Intent(updatedTime)
            time++
            intent.putExtra(currentTime, time)
            sendBroadcast(intent)
        }

    }

}