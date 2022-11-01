package com.playground.feature.more.ui.jetpack.datastore

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.playground.core.ui.ext.lazyViewBinding
import com.playground.core.ui.ext.observe
import com.playground.feature.more.R
import com.playground.feature.more.databinding.FragmentDataStoreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DataStoreFragment : Fragment(R.layout.fragment_data_store) {

    private val binding by lazyViewBinding(FragmentDataStoreBinding::bind)
    private val dataStoreViewModel by viewModels<DataStoreViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initObserver()
    }

    private fun initListener() {
        with(binding) {
            btnSave.setOnClickListener {
                dataStoreViewModel.setDataText(etDataStore.text.toString())
            }
        }
    }

    private fun initObserver() {
        observe(dataStoreViewModel.dataText) {
            binding.tvLastText.text = it
        }
    }
}