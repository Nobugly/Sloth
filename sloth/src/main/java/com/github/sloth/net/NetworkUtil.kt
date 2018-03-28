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
 */
@RequiresPermission(ACCESS_NETWORK_STATE)
fun getNetworkType(): Int {
    return getActiveNetworkInfo().type
}

/**
 * [getNetworkTypeName] 返回网络类型名称
 */
@RequiresPermission(ACCESS_NETWORK_STATE)
fun getNetworkTypeName(): String {
    return getActiveNetworkInfo().typeName
}

/**
 * [isMobileData] 当前网络是否为移动数据
 */
@RequiresPermission(ACCESS_NETWORK_STATE)
fun isMobileData(): Boolean {
    val networkInfo = getActiveNetworkInfo()
    return networkInfo.isConnected && networkInfo.type == ConnectivityManager.TYPE_MOBILE
}

/**
 * [getActiveNetworkInfo] 获取活跃网络信息
 */
@RequiresPermission(ACCESS_NETWORK_STATE)
fun getActiveNetworkInfo(): NetworkInfo {
    val manager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return manager.activeNetworkInfo
}
