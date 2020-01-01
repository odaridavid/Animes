package com.k0d4black.animes

import android.animation.Animator
import android.animation.AnimatorInflater
import android.content.Context
import android.widget.Toast
import androidx.annotation.AnimatorRes

/**
 * Created By David Odari
 * On 01/01/20
 *
 **/

fun Context.showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

fun Context.animationResourceLoader(@AnimatorRes animator: Int): Animator =
    AnimatorInflater.loadAnimator(this, animator)