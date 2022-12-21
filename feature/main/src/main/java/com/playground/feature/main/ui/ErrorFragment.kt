package com.playground.feature.main.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.playground.core.ui.ext.lazyViewBinding
import com.playground.feature.main.R
import com.playground.feature.main.databinding.FragmentErrorBinding
import com.playground.feature.main.navigation.space.MainNavSpace
import dagger.hilt.android.AndroidEntryPoint
import splitties.views.onClick
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ErrorFragment : Fragment(R.layout.fragment_error) {

    private val binding by lazyViewBinding(FragmentErrorBinding::bind)
    private var errorDescription: Throwable? = null
    @Inject lateinit var space: MainNavSpace

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        errorDescription = getErrorIntent(requireActivity().intent)
        initView()
    }

    private fun initView() {
        with(binding) {
            tvDescription.text = errorDescription?.message
            btnSendFeedback.onClick {

            }
            btnRestartApp.onClick {
                space.orbit.toMenu()
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