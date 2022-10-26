package com.playground.core.ui.base.fragment

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

class BaseViewBindingFragmentImpl<V: ViewDataBinding>: BaseViewBindingFragment<V> {

    private var fragmentName: String = ""

    private lateinit var _binding: V
    override val binding: V
        get() = _binding

    override fun initBinding(binding: V, fragment: Fragment, onBound: (V.() -> Unit)?): View {
        _binding = binding
        fragmentName = fragment::class.simpleName ?: "N/A"
        onBound?.invoke(binding)
        return binding.root
    }

    override fun requiredBinding(onBound: (V.() -> Unit)?) {
        onBound?.invoke(binding)
    }

    override fun onDestroyViewBinding() {
//        _binding = null
    }
}