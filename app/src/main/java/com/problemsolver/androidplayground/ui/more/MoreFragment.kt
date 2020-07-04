package com.problemsolver.androidplayground.ui.more

import androidx.appcompat.app.AppCompatDelegate
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.MoreFragmentBinding

class MoreFragment : BaseFragment<MoreFragmentBinding>() {

    override fun setLayout() = R.layout.more_fragment

    override fun viewOnReady() {
        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}