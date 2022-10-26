package com.playground.core.ui.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
//import com.playground.android.ui.MainActivity
import com.playground.core.ui.analytics.screen.ScreenAnalyticsContract
import com.playground.core.ui.analytics.screen.ScreenAnalyticsImpl
//import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<V: ViewDataBinding>:
    Fragment(),
    BaseViewBindingFragment<V> by BaseViewBindingFragmentImpl(),
    ScreenAnalyticsContract by ScreenAnalyticsImpl()
{
    /*private val compositeDisposableDelegate by lazy { CompositeDisposable() }
    @SuppressWarnings
    val compositeDisposable = compositeDisposableDelegate
    lateinit var mainActivity: MainActivity*/

    @LayoutRes
    abstract fun setLayout(): Int

    abstract fun viewOnReady()

    open fun observeData() = Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*mainActivity = activity as MainActivity
        mainActivity.showLoading(false)*/
        registerLifecycleOwner(this)
        return initBinding(DataBindingUtil.inflate(layoutInflater, setLayout(), container, false), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        viewOnReady()
        observeData()
    }

    override fun onDestroy() {
        /*with(compositeDisposable) {
            dispose()
            clear()
        }*/
        onDestroyViewBinding()
        super.onDestroy()
    }
}