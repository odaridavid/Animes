package com.k0d4black.animes

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator.REVERSE
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.annotation.AnimatorRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun rotateAnimation(view: View) = setAnimator(R.animator.rotate_animation)

    fun scaleAnimation(view: View) = setAnimator(R.animator.scale_animation)

    fun alphaAnimation(view: View) = setAnimator(R.animator.alpha_animation)

    fun translateAnimation(view: View) = setAnimator(R.animator.translate_animation)

    fun setAnimation(view: View) = setAnimator(R.animator.set_animation)

    fun objectAnimatorInitFromCode() {
        //Xml alternative
        ObjectAnimator.ofFloat(animation_text_view, "alpha", 0.0f, 1.0f).apply {
            duration = 900
            repeatCount = 1
            repeatMode = REVERSE
            addListener(AnimatorListener(this@MainActivity))
            start()
        }
    }

    fun animatorSetInitFromCode(view: View) {
        val rootSet = AnimatorSet()
        val flip = ObjectAnimator.ofFloat(animation_text_view, "rotationX", 0.0f, 200.0f)
        flip.duration = 400
        flip.repeatMode = REVERSE
        flip.repeatCount = 1
        val scale = ObjectAnimator.ofFloat(animation_text_view, "rotationY", 0.0f, 120.0f)
        scale.duration = 400
        scale.interpolator = AccelerateDecelerateInterpolator()
        scale.repeatCount = 1
        scale.repeatMode = REVERSE
//        rootSet.playSequentially(flip, scale)
        rootSet.play(flip).before(scale)//after,with-play sequentially
        rootSet.start()
    }

    fun viewPropertyAnimator(view: View) {
        val vpa = animation_text_view.animate()
        vpa.apply {
            duration = 500
            rotationX(120.0f)
            scaleX(1.2f)
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }

    }

    private fun setAnimator(@AnimatorRes animator: Int) {
        animationResourceLoader(animator).apply {
            setTarget(animation_text_view)
            addListener(AnimatorListener(this@MainActivity))
            start()
        }
    }
}
