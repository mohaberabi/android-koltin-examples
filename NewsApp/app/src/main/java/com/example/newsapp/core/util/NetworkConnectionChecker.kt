package com.example.newsapp.core.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build


abstract class NetworkConnectionChecker(context: Context) {

    abstract fun isConnected(): Boolean
    protected val connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    protected val isNewApi = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
}

class NetworkConnectionCheckerImpl(
    private val context: Context
) :
    NetworkConnectionChecker(context) {

    override fun isConnected(): Boolean {
        var result = false
        if (isNewApi) {
            connectivityManager.run {
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.run {
                    result = isConnected
                }
            }
        } else {
            @Suppress("DEPRECATION")
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    if (isWifi) {
                        result = true
                    } else if (isMobile) {
                        result = true
                    }
                }
            }
        }
        return result
    }
}

@Suppress("DEPRECATION")
val ConnectivityManager.isWifi: Boolean
    get() = this.activeNetworkInfo?.type == ConnectivityManager.TYPE_WIFI

@Suppress("DEPRECATION")
val ConnectivityManager.isMobile: Boolean
    get() = this.activeNetworkInfo?.type == ConnectivityManager.TYPE_MOBILE

val NetworkCapabilities.isConnected: Boolean
    get() = when {
        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
