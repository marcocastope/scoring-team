package com.marcocastope.scoringteam.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf

inline fun <reified T : Activity> Context.navigateTo(vararg pairs: Pair<String, Any?>) {
    Intent(this, T::class.java).apply {
        putExtras(bundleOf(*pairs))
        startActivity(this)
    }
}