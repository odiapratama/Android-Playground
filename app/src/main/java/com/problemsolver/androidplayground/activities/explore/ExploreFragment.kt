package com.problemsolver.androidplayground.activities.explore

import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.ExploreFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ExploreFragment : BaseFragment<ExploreFragmentBinding>() {

    private val viewModel: ExploreViewModel by viewModel()

    override fun getLayout() = R.layout.explore_fragment

    override fun viewOnReady() {}
}