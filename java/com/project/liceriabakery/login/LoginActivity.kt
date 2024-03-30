package com.project.liceriabakery.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.project.liceriabakery.MainActivity
import com.project.liceriabakery.R
import com.project.liceriabakery.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edEmail = binding.edLoginEmail
        val edPassword = binding.edLoginPassword

        binding.btnLogin.setOnClickListener {
            if (edPassword.text?.isEmpty() == true) {
                edPassword.error = "Password cannot be empty"
            }
            if (edEmail.text?.isEmpty() == true) {
                edEmail.error = "Email cannot be empty"
            }

            if (edPassword.error == null && edEmail.error == null) {
                if (edEmail.text.toString() == EMAIL && edPassword.text.toString() == PASSWORD) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Snackbar.make(binding.root, "Password dan Email salah", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
        playAnimation()
    }

    private fun playAnimation() {
        val imglogo = ObjectAnimator.ofFloat(binding.logo, View.ALPHA, 1f).setDuration(400)
        val emailEditTextLayout = ObjectAnimator.ofFloat(binding.edtEmailLayout, View.ALPHA, 1f).setDuration(400)
        val passwordTextView = ObjectAnimator.ofFloat(binding.edtPasswordLayout, View.ALPHA, 1f).setDuration(400)
        val login = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(400)

        AnimatorSet().apply {
            playSequentially(
                imglogo,
                emailEditTextLayout,
                passwordTextView,
                login
            )
            startDelay = 500
        }.start()
    }

    companion object {
        const val EMAIL = "user@gmail.com"
        const val PASSWORD = "user12345"
    }
}