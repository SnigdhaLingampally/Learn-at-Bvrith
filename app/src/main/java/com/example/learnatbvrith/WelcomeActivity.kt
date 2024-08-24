package com.example.learnatbvrith

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.learnatbvrith.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fadeInText()

        binding.enterText.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun fadeInText() {
        val fadeIn = AlphaAnimation(0.0f, 1.0f).apply {
            duration = 2000 // duration in milliseconds
            fillAfter = true
        }

        binding.welcomeText.startAnimation(fadeIn)

        // Optionally, you can automatically show the enterText after a delay
        Handler(Looper.getMainLooper()).postDelayed({
            binding.enterText.visibility = View.VISIBLE
        }, 2000) // 2 seconds delay
    }
}
