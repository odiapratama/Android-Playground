package com.problemsolver.androidplayground.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<V: ViewDataBinding>: Fragment(), BaseViewBindingFragment<V> by BaseViewBindingFragmentImpl<V>() {

    private val compositeDisposableDelegate by lazy { CompositeDisposable() }
    @SuppressWarnings
    val compositeDisposable = compositeDisposableDelegate

    @LayoutRes
    abstract fun setLayout(): Int

    abstract fun viewOnReady()

    open fun observeData() = Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initBinding(DataBindingUtil.inflate(layoutInflater, setLayout(), container, false), this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this
        viewOnReady()
        observeData()
    }

    override fun onDestroy() {
        with(compositeDisposable) {
            dispose()
            clear()
        }
        super.onDestroy()
    }
}