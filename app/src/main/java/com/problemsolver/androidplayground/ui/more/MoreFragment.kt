package com.problemsolver.androidplayground.ui.more

import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.MoreFragmentBinding
import com.problemsolver.androidplayground.utils.BiometricUtils

class MoreFragment : BaseFragment<MoreFragmentBinding>() {

    private val navController by lazy { findNavController() }

    override fun setLayout() = R.layout.more_fragment

    override fun viewOnReady() {

        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        binding.btnBiometric.setOnClickListener {
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

        binding.btnJetpack.setOnClickListener {
            navController.navigate(
                MoreFragmentDirections.actionMoreToJetpackJourney()
            )
        }

        binding.btnUIDrag.setOnClickListener {
            navController.navigate(
                MoreFragmentDirections.actionMoreToViewExploreJourney()
            )
        }
    }
}