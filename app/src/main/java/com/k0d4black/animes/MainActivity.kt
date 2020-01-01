package com.k0d4black.animes

import android.animation.ObjectAnimator
import android.animation.ValueAnimator.REVERSE
import android.os.Bundle
import android.view.View
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

    fun objectAnimator() {
        //Xml alternative
        ObjectAnimator.ofFloat(animation_text_view, "alpha", 0.0f, 1.0f).apply {
            duration = 900
            repeatCount = 1
            repeatMode = REVERSE
            addListener(AnimatorListener(this@MainActivity))
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
