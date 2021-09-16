package com.marcocastope.scoringteam.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.os.bundleOf

inline fun <reified T : Activity> Context.navigateTo(vararg pairs: Pair<String, Any?>) {
    Intent(this, T::class.java).apply {
        putExtras(bundleOf(*pairs))
        startActivity(this)
    }
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}