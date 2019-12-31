package com.k0d4black.animes

import android.animation.AnimatorInflater
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

    private fun setAnimator(@AnimatorRes animator: Int) {
        AnimatorInflater.loadAnimator(this, animator).apply {
            setTarget(animation_text_view)
            start()
        }
    }
}
