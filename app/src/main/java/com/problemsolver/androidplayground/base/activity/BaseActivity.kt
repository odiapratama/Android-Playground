package com.problemsolver.androidplayground.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<V: ViewDataBinding>: AppCompatActivity(), BaseViewBindingActivity<V> by BaseViewBindingActivityImpl() {

    private val compositeDisposableDelegate by lazy { CompositeDisposable() }
    @SuppressWarnings
    val compositeDisposable = compositeDisposableDelegate

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun viewOnReady()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding(DataBindingUtil.setContentView(this, getLayout()), this)
        binding.lifecycleOwner = this
        viewOnReady()
    }

    override fun onDestroy() {
        with(compositeDisposable) {
            dispose()
            clear()
        }
        super.onDestroy()
    }
}