package com.ibm.chefcito.core.animation

import android.view.View
import android.view.animation.AlphaAnimation

class FadeInAnimation: AnimationStrategy {
    override fun animate(view: View, duration: Long) {
        val fadeInAnimation = AlphaAnimation(0.0f, 1.0f)
        fadeInAnimation.duration = duration
        view.startAnimation(fadeInAnimation)
    }
}