package com.example.coinapp.view.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.coinapp.R
import timber.log.Timber

// splash 화면 만들기
// handler -> 3초 뒤에 다른 액티비티(MainActivity로 이동)

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        Timber.d("onCreate1")
    }
}