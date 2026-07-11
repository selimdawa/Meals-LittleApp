package com.littleapp.meals.activities

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.littleapp.meals.CLASS
import com.littleapp.meals.databinding.ActivitySplashBinding
import com.littleapp.meals.utils.THEME
import com.littleapp.meals.utils.VOID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val context: Context = this@SplashActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME.setThemeOfApp(context)
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({ launch() }, TIME_PER_MILLIS)
    }

    private fun launch() {
        VOID.Intent1(context, CLASS.MAIN)
        finish()
    }

    companion object {
        private const val TIME_PER_MILLIS: Long = 1000
    }
}