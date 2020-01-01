package com.k0d4black.animes

import android.animation.Animator
import android.content.Context

/**
 * Created By David Odari
 * On 01/01/20
 *
 **/
class AnimatorListener(private val context: Context) : Animator.AnimatorListener {

    override fun onAnimationRepeat(animator: Animator?) {
        context.showToast("Animation Repeated")
    }

    override fun onAnimationEnd(animator: Animator?) {
        context.showToast("Animation Ended")
    }

    override fun onAnimationCancel(animator: Animator?) {
        context.showToast("Animation Cancelled")
    }

    override fun onAnimationStart(animator: Animator?) {
        context.showToast("Animation Started")
    }

}