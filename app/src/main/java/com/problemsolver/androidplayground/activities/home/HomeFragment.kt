package com.problemsolver.androidplayground.activities.home

import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.HomeFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeFragmentBinding>() {

    private val viewModel: HomeViewModel by viewModel()

    override fun getLayout() = R.layout.home_fragment

    override fun viewOnReady() {}
}