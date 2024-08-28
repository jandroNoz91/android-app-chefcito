package com.ibm.chefcito.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.ibm.chefcito.R
import com.ibm.chefcito.auth.presentation.AuthMainActivity
import com.ibm.chefcito.core.animation.AnimationStrategy
import com.ibm.chefcito.core.animation.splash.SplashAnimation
import com.ibm.chefcito.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 2000
    private lateinit var binding: ActivitySplashBinding
    private lateinit var animationStrategy: AnimationStrategy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startSplashAnimation()


        lifecycleScope.launch {
            delay(splashTimeOut)
            redirectToAppropriateActivity()
        }
    }

    private fun startSplashAnimation() {
        animationStrategy = SplashAnimation()
        animationStrategy.animate(binding.imageViewChefcito)
    }

    private fun isLoggedIn(): Boolean {
        return false // TODO: Firebase Auth.
    }

    private fun redirectToAppropriateActivity() {
//        val intent = if(isLoggedIn()) {
//            Intent(this, PokemonMainActivity::class.java)
//        } else {
//            Intent(this, AuthMainActivity::class.java)
//        }
        val intent = Intent(this, AuthMainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK  )
        startActivity(intent)
        finish()
    }
}