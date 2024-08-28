package com.ibm.chefcito.core.animation

import android.view.View
import android.view.animation.AlphaAnimation

class FadeOutAnimation : AnimationStrategy {
    override fun animate(view: View, duration: Long) {
        val fadeOutAnimation = AlphaAnimation(1f, 0f)
        fadeOutAnimation.duration = duration
        view.startAnimation(fadeOutAnimation)
    }
}