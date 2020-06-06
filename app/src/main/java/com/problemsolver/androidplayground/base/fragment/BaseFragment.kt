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
    val compositeDisposable = compositeDisposableDelegate

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun viewOnReady()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initBinding(DataBindingUtil.inflate(layoutInflater, getLayout(), container, false), this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this
        viewOnReady()
    }

    override fun onDestroyOptionsMenu() {
        with(compositeDisposable) {
            dispose()
            clear()
        }
        super.onDestroyOptionsMenu()
    }
}