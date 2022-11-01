package com.playground.feature.more.ui.jetpack

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.playground.core.ui.ext.lazyViewBinding
import com.playground.feature.more.R
import com.playground.feature.more.databinding.FragmentJetpackBinding

class JetpackFragment : Fragment(R.layout.fragment_jetpack) {

    private val binding by lazyViewBinding(FragmentJetpackBinding::bind)
    private val navController by lazy { findNavController() }

    private val listJetpack = listOf(
        "Data Store",
        "Motion Layout",
        "Work Manager"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.rvJetpack.adapter =
            JetpackAdapter(
                listJetpack
            ) {
                when (it) {
                    listJetpack[0] -> navController.navigate(
                        JetpackFragmentDirections.actionJetpackFragmentToDataStoreFragment()
                    )
                    listJetpack[1] -> navController.navigate(
                        JetpackFragmentDirections.actionJetpackFragmentToMotionFragment()
                    )
                    listJetpack[2] -> navController.navigate(
                        JetpackFragmentDirections.actionJetpackFragmentToWorkManagerFragment()
                    )
                }
            }
    }
}