package com.problemsolver.androidplayground.activities.more

import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.MoreFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MoreFragment : BaseFragment<MoreFragmentBinding>() {

    private val viewModel: MoreViewModel by viewModel()

    override fun getLayout() = R.layout.more_fragment

    override fun viewOnReady() {}
}