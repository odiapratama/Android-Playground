package com.playground.android.ui.threading.coroutines

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.playground.android.R
import com.playground.core.ui.ext.observe

class CoroutinesFragment : Fragment(R.layout.coroutines_fragment) {

    private lateinit var viewModel: CoroutinesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewModel = ViewModelProvider(this)[CoroutinesViewModel::class.java]

        viewModel.getLoadData()

        observe(viewModel.data) {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}