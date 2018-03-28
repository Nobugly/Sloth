package com.github.sloth.system

import android.os.Build

/**
 * [phoneBrand] 手机品牌
 */
val phoneBrand = Build.BRAND!!

/**
 * [phoneModel] 手机型号
 */
val phoneModel = Build.MODEL!!

/**
 * [manufacturer] 手机制造商
 */
val manufacturer = Build.MANUFACTURER!!

/**
 * [buildRelease] 系统编译版本
 */
val buildRelease = Build.VERSION.RELEASE!!
