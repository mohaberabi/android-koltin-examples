package com.example.servicesexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBgServices : Service() {


    init {

        Log.i(
            "service",
            "Service has been created"
        )
    }


    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {
        val name = intent?.getStringExtra("name") ?: ""
        Log.i(
            "service",
            "Service has been started ${name}"
        )

        return START_STICKY
    }

    override fun onBind(intnet: Intent?): IBinder? = null


    override fun onDestroy() {
        Log.i(
            "service",
            "Service has been destroyed"
        )
        super.onDestroy()
    }
}