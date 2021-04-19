package com.problemsolver.androidplayground.ui.threading.coroutines

import androidx.lifecycle.ViewModelProvider
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.CoroutinesFragmentBinding

class CoroutinesFragment : BaseFragment<CoroutinesFragmentBinding>() {

    private lateinit var viewModel: CoroutinesViewModel

    override fun setLayout() = R.layout.coroutines_fragment

    override fun viewOnReady() {
        viewModel = ViewModelProvider(this).get(CoroutinesViewModel::class.java)
    }
}