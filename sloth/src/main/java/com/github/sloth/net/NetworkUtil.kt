package com.github.sloth.net

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.support.annotation.RequiresPermission
import com.github.sloth.app.app

/**
 * [hasAvailableNetworkConnected] 是否有可用的网络连接
 * @return 如果返回true则表示有可用网络连接false则相反
 */
@RequiresPermission(ACCESS_NETWORK_STATE)
fun hasAvailableNetworkConnected(): Boolean {
    val manager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
        val networks = manager.allNetworks
        networks.forEach {
            val networkInfo = manager.getNetworkInfo(it)
            if (networkInfo.state == NetworkInfo.State.CONNECTED) {
                return true
            }
        }
    } else {
        val allNetworkInfo = manager.allNetworkInfo
        allNetworkInfo.filter { it.state == NetworkInfo.State.CONNECTED }.forEach { return true }
    }
    return false
}

/**
 * [getNetworkType] 返回网络类型
 *
 * @return NetworkType
 * 返回-1则代表没有网络连接类型
 * 返回0则表示移动网络类型
 * 返回1则表示WIFI网络类型
 */
@RequiresPermission(ACCESS_NETWORK_STATE)
fun getNetworkType(): Int {
    val manager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return manager.activeNetworkInfo?.type ?: -1
}

/**
 * [getNetworkTypeName] 返回网络类型名称
 * @return NetworkTypeName
 * 如果返回Null则没有网络类型连接
 */
@RequiresPermission(ACCESS_NETWORK_STATE)
fun getNetworkTypeName(): String {
    val manager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return manager.activeNetworkInfo?.typeName ?: "Null"
}

