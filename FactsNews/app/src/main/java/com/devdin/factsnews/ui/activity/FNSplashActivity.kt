package com.devdin.factsnews.ui.activity

import android.os.Bundle
import android.os.Handler


class FNSplashActivity : FNBaseActivity() {
      val SPLASH_TIME_OUT = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.devdin.factsnews.R.layout.activity_splash)
        Handler().postDelayed({//SAM
            goToNextScreenClearBackStack(FNHomeActivity::class.java)
        }, SPLASH_TIME_OUT)
    }


}
