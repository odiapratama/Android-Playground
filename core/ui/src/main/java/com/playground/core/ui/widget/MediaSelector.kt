package com.playground.core.ui.widget

import android.animation.Animator
import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.*
import android.view.animation.*
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.constraintlayout.widget.ConstraintLayout
import com.playground.core.ui.R
import com.playground.core.ui.utils.AnimUtils
import kotlin.math.max

class MediaSelector(context: Context) : PopupWindow() {

    private val animationDuration = 300L
    private lateinit var currentAnchor: View
    private val ivCamera: ImageView
    private val ivVideoCam: ImageView
    private val ivPhotoLibrary: ImageView

    init {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout =
            layoutInflater.inflate(R.layout.media_selector, null, false) as ConstraintLayout
        ivCamera = layout.findViewById(R.id.ivCamera)
        ivVideoCam = layout.findViewById(R.id.ivVideoCam)
        ivPhotoLibrary = layout.findViewById(R.id.ivPhotoLibrary)
        contentView = layout
        height = ConstraintLayout.LayoutParams.MATCH_PARENT
        width = ConstraintLayout.LayoutParams.WRAP_CONTENT
        animationStyle = 0
        isClippingEnabled = false
        inputMethodMode = INPUT_METHOD_NOT_NEEDED
        isFocusable = true
        isTouchable = true
    }

    fun show(activity: Activity, anchor: View) {
        val rect = Rect()
        activity.window.decorView.getWindowVisibleDisplayFrame(rect)
        val windowHeight = activity.window.decorView.height
        val y = windowHeight - rect.bottom
        currentAnchor = anchor


        isAttachedInDecor = false

        showAtLocation(anchor, Gravity.BOTTOM, 0, y)
        contentView.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                contentView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                animateCircularWindowIn(anchor, contentView)
            }
        })

        animateViewIn(ivCamera, animationDuration / 2)
        animateViewIn(ivVideoCam, animationDuration / 3)
        animateViewIn(ivPhotoLibrary, animationDuration / 4)
    }

    override fun dismiss() {
        animateCircularWindowOut(currentAnchor, contentView)
    }

    private fun animateCircularWindowIn(anchor: View, contentView: View) {
        val coordinates = AnimUtils.getClickOrigin(anchor, contentView)
        val animator = ViewAnimationUtils.createCircularReveal(
            contentView,
            coordinates.first,
            coordinates.second,
            0f,
            max(contentView.width, contentView.height).toFloat()
        )
        animator.duration = animationDuration
        animator.start()
    }

    private fun animateInTranslate(contentView: View) {
        val animation = TranslateAnimation(0f, 0f, contentView.height.toFloat(), 0f)
        animation.duration = animationDuration
        getContentView().startAnimation(animation)
    }

    private fun animateCircularWindowOut(anchor: View, contentView: View) {
        val coordinates = AnimUtils.getClickOrigin(anchor, contentView)
        val animator = ViewAnimationUtils.createCircularReveal(
            getContentView(),
            coordinates.first,
            coordinates.second,
            max(getContentView().height, getContentView().height).toFloat(),
            0f
        )
        animator.duration = animationDuration
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator) = Unit
            override fun onAnimationCancel(p0: Animator) = Unit
            override fun onAnimationStart(p0: Animator) = Unit
            override fun onAnimationEnd(p0: Animator) {
                super@MediaSelector.dismiss()
            }
        })
        animator.start()
    }

    private fun animateOutTranslate(contentView: View) {
        val animation =
            TranslateAnimation(0f, 0f, 0f, (contentView.top + contentView.height).toFloat())
        animation.duration = animationDuration
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) = Unit
            override fun onAnimationStart(animation: Animation?) = Unit
            override fun onAnimationEnd(animation: Animation?) {
                super@MediaSelector.dismiss()
            }
        })
        getContentView().startAnimation(animation)
    }

    private fun animateViewIn(view: View, delay: Long) {
        val animation = AnimationSet(true)
        val scale = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animation.addAnimation(scale)
        animation.interpolator = OvershootInterpolator(1f)
        animation.duration = animationDuration
        animation.startOffset = delay
        view.startAnimation(animation)
    }
}