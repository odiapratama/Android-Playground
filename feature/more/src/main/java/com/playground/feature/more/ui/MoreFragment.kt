package com.playground.feature.more.ui

import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.playground.core.utils.BiometricUtils
import com.playground.feature.more.navigation.space.MoreNavSpace
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoreFragment : UiMoreFragment() {

    @Inject
    lateinit var space: MoreNavSpace

    override fun darkMoreAction(isChecked: Boolean) {
        if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun biometricAction() {
        if (BiometricUtils.authenticate(requireContext())) {
            BiometricUtils.biometricPromptExecutor(requireActivity(), { errorCode, errString ->
                Toast.makeText(requireContext(), "$errorCode $errString", Toast.LENGTH_LONG)
                    .show()
            }, {
                Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()
            }, {
                Toast.makeText(requireContext(), "Failed", Toast.LENGTH_LONG).show()
            }).authenticate(BiometricUtils.displayBiometricAuth())
        }
    }

    override fun jetpackAction() = space.orbit.toJetpack()

    override fun uiDragAction() = space.orbit.toUiDrag()

    override fun threadingAction() = space.orbit.toThreading()

    override fun throwErrorAction() = space.orbit.toError()
}