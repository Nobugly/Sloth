package com.github.sloth.app

import android.annotation.SuppressLint
import android.app.Application

/**
 * 通过反射获取的当前Application实例
 */
@SuppressLint("StaticFieldLeak", "PrivateApi")
val app = try {
    Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null) as Application
} catch (ex: Exception) {
    Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null) as Application
}
