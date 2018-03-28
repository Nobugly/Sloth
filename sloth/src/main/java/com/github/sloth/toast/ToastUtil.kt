package com.github.sloth.toast

import android.widget.Toast
import com.github.sloth.app.app

/**
 * 短Toast
 * @param message
 */
fun shortToast(message: Int) {
    Toast.makeText(app, message, Toast.LENGTH_SHORT).show()
}

/**
 * 短Toast
 * @param message
 */
fun shortToast(message: String) {
    Toast.makeText(app, message, Toast.LENGTH_SHORT).show()
}

/**
 * 长Toast
 * @param message
 */
fun longToast(message: Int) {
    Toast.makeText(app, message, Toast.LENGTH_LONG).show()
}

/**
 * 长Toast
 * @param message
 */
fun longToast(message: String) {
    Toast.makeText(app, message, Toast.LENGTH_LONG).show()
}
