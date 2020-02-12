package com.devdin.factsnews.ui.activity

import android.os.Bundle
import android.os.Handler


class FNSplashActivity : FNBaseActivity() {
    private val SPLASH_TIME_OUT = 5000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.devdin.factsnews.R.layout.activity_splash)
        Handler().postDelayed(Runnable() {
            goToNextScreenClearBackStack(FNHomeActivity::class.java)
        }, SPLASH_TIME_OUT)
    }


}
