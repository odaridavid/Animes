package com.k0d4black.animes

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animating_drawables.*

class AnimatingDrawablesActivity : AppCompatActivity() {

    lateinit var catAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animating_drawables)
    }

    override fun onResume() {
        super.onResume()
        animation_image_view.setBackgroundResource(R.drawable.cat_animation_list)
        catAnimation = animation_image_view.background as AnimationDrawable
        catAnimation.start()
    }

    fun startStopAnimation(view: View) {
        if (catAnimation.isRunning)
            catAnimation.stop()
        else catAnimation.start()
    }
}
