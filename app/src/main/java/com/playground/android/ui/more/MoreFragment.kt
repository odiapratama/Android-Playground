package com.playground.android.ui.more

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.playground.android.R
import com.playground.android.databinding.MoreFragmentBinding
import com.playground.core.utils.BiometricUtils
import com.playground.core.ui.ext.lazyViewBinding

class MoreFragment : Fragment(R.layout.more_fragment) {

    private val navController by lazy { findNavController() }

    private val binding by lazyViewBinding(MoreFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

            btnBiometric.setOnClickListener {
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

            btnJetpack.setOnClickListener {
                navController.navigate(
                    MoreFragmentDirections.actionMoreToJetpackJourney()
                )
            }

            btnUIDrag.setOnClickListener {
                navController.navigate(
                    MoreFragmentDirections.actionMoreToViewExploreJourney()
                )
            }

            btnThreading.setOnClickListener {
                navController.navigate(
                    MoreFragmentDirections.actionMoreToThreadingJourney()
                )
            }
        }
    }
}