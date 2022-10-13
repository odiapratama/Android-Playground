package com.problemsolver.androidplayground.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.problemsolver.androidplayground.ui.MainActivity
import com.problemsolver.androidplayground.utils.lazyview.LazyViewBinding
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<V: ViewDataBinding>: Fragment(), BaseViewBindingFragment<V> by BaseViewBindingFragmentImpl() {

    private val compositeDisposableDelegate by lazy { CompositeDisposable() }
    @SuppressWarnings
    val compositeDisposable = compositeDisposableDelegate
    lateinit var mainActivity: MainActivity

    @LayoutRes
    abstract fun setLayout(): Int

    abstract fun viewOnReady()

    open fun observeData() = Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainActivity = activity as MainActivity
        mainActivity.showLoading(false)
        return initBinding(DataBindingUtil.inflate(layoutInflater, setLayout(), container, false), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

abstract class BaseFragment2<V: ViewDataBinding>: Fragment(), BaseViewBindingFragment<V> by BaseViewBindingFragmentImpl() {

    private val compositeDisposableDelegate by lazy { CompositeDisposable() }
    @SuppressWarnings
    val compositeDisposable = compositeDisposableDelegate
    lateinit var mainActivity: MainActivity

    abstract fun getLazyView(): LazyViewBinding<V>

    abstract fun viewOnReady()

    open fun observeData() = Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainActivity = activity as MainActivity
        mainActivity.showLoading(false)
        return initBinding(getLazyView().value, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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