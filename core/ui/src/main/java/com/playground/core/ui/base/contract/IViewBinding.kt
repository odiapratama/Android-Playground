package com.playground.core.ui.base.contract

import androidx.viewbinding.ViewBinding

interface IViewBinding<V : ViewBinding> {
    val binding: V
}