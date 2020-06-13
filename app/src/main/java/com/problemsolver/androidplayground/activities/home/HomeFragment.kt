package com.problemsolver.androidplayground.activities.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.HomeFragmentBinding
import com.problemsolver.androidplayground.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>() {

    private val vm by viewModels<HomeViewModel>()

    override fun getLayout() = R.layout.home_fragment

    override fun viewOnReady() {
        observe(vm.trending) {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
        }
    }
}