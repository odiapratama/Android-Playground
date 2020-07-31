package com.problemsolver.androidplayground.utils

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

object BiometricUtils {
    fun authenticate(context: Context): Boolean {
        return when (BiometricManager.from(context).canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS -> true
            else -> false
        }
    }

    fun biometricPromptExecutor(
        context: FragmentActivity,
        onError: (errorCode: Int, errString: String) -> Unit = { _, _ -> },
        onSuccess: (BiometricPrompt.AuthenticationResult) -> Unit = {},
        onFailed: () -> Unit = {}
    ): BiometricPrompt {
        return BiometricPrompt(
            context,
            ContextCompat.getMainExecutor(context),
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    onError(errorCode, errString.toString())
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    onSuccess(result)
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    onFailed()
                }
            })
    }

    fun displayBiometricAuth(): BiometricPrompt.PromptInfo {
        return BiometricPrompt.PromptInfo.Builder()
            .setTitle("Title")
            .setSubtitle("Subtitle")
            .setDescription("Description")
            .setNegativeButtonText("Cancel")
            .build()
    }
}