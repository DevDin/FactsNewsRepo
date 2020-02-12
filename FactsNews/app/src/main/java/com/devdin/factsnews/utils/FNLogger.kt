package com.devdin.factsnews.utils

import android.util.Log

class FNLogger {

    companion object Logger {
        const val  Log_TAG: String = "FactNewsLog"
        fun log(module: String, message: String) {
            Log.d(Log_TAG, "$module : $message")
        }
    }
}