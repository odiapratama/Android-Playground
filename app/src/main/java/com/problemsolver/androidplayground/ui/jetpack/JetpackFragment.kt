package com.problemsolver.androidplayground.ui.jetpack

import androidx.navigation.fragment.findNavController
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.FragmentJetpackBinding

class JetpackFragment : BaseFragment<FragmentJetpackBinding>() {

    private val navController by lazy { findNavController() }

    private val listJetpack = listOf(
        "Data store",
        "Motion Layout"
    )

    override fun setLayout() = R.layout.fragment_jetpack

    override fun viewOnReady() {
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
                }
            }
    }
}