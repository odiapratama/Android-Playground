package com.playground.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.playground.android.databinding.ActivityErrorBinding
import splitties.views.onClick
import timber.log.Timber

class ErrorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityErrorBinding
    private var errorDescription: Throwable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_error)
        errorDescription = getErrorIntent(intent)
        initView()
    }

    private fun initView() {
        with(binding) {
            tvDescription.text = errorDescription?.message
            btnSendFeedback.onClick {

            }
            btnSendFeedback.onClick {
                
            }
        }
    }

    private fun getErrorIntent(intent: Intent): Throwable? {
        return try {
            Gson().fromJson(intent.getStringExtra("error"), Throwable::class.java)
        } catch (e: Exception) {
            Timber.d("Error parsing intent data", e)
            null
        }
    }
}