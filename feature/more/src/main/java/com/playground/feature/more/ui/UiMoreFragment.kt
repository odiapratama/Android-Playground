package com.playground.feature.more.ui

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.fragment.app.Fragment
import com.playground.core.ui.base.contract.INavigation
import com.playground.core.ui.base.contract.IViewBinding
import com.playground.core.ui.ext.lazyViewBinding
import com.playground.feature.more.R
import com.playground.feature.more.databinding.MoreFragmentBinding
import splitties.views.onClick

abstract class UiMoreFragment :
    Fragment(R.layout.more_fragment),
    IViewBinding<MoreFragmentBinding>,
    INavigation, IMoreAction, OnClickListener, OnCheckedChangeListener {

    override val binding: MoreFragmentBinding by lazyViewBinding(MoreFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        with(binding) {
            when (p0) {
                switchDarkMode -> darkMoreAction(p1)
            }
        }
    }

    override fun onClick(p0: View?) {
        with(binding) {
            when (p0) {
                btnBiometric -> biometricAction()
                btnJetpack -> jetpackAction()
                btnUIDrag -> uiDragAction()
                btnThreading -> threadingAction()
                btnError -> throwErrorAction()
            }
        }
    }

    private fun initListener() {
        with(binding) {
            switchDarkMode.setOnCheckedChangeListener(this@UiMoreFragment)
            btnBiometric.onClick(this@UiMoreFragment)
            btnJetpack.onClick(this@UiMoreFragment)
            btnUIDrag.onClick(this@UiMoreFragment)
            btnThreading.onClick(this@UiMoreFragment)
            btnError.onClick(this@UiMoreFragment)
        }
    }
}